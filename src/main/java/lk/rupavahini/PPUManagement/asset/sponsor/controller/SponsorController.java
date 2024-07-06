package lk.rupavahini.PPUManagement.asset.sponsor.controller;


import lk.rupavahini.PPUManagement.asset.sponsor.entity.Sponsor;
import lk.rupavahini.PPUManagement.asset.sponsor.service.SponsorService;
import lk.rupavahini.PPUManagement.util.service.MakeAutoGenerateNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/sponsor")
public class SponsorController {
    private final SponsorService sponsorService;
    private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;

    @Autowired
    public SponsorController(SponsorService sponsorService, MakeAutoGenerateNumberService makeAutoGenerateNumberService) {
        this.sponsorService = sponsorService;
        this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
    }

    private String commonThings(Model model, Sponsor sponsor, Boolean addState) {
        model.addAttribute("sponsor", sponsor);
        model.addAttribute("addStatus", addState);
        return "sponsor/addSponsor";
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("sponsor", sponsorService.findAll());
        return "sponsor/sponsor";
    }


    @GetMapping("/add")
    public String addForm(Model model) {
        return commonThings(model, new Sponsor(), true);
    }

    @PostMapping(value = {"/save", "/update"})
    public String persist(@Valid @ModelAttribute Sponsor sponsor, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            return commonThings(model, sponsor, true);
        }
        if (sponsor.getContactOne() != null) {
            sponsor.setContactOne(makeAutoGenerateNumberService.phoneNumberLengthValidator(sponsor.getContactOne()));
        }
        if (sponsor.getContactTwo() != null) {
            sponsor.setContactTwo(makeAutoGenerateNumberService.phoneNumberLengthValidator(sponsor.getContactTwo()));
        }
        //if sponsor has id that sponsor is not a new sponsor
        if (sponsor.getId() == null) {
            //if there is not sponsor in db
            Sponsor DBSponsor = sponsorService.lastSponsor();

            if (DBSponsor == null) {
                //need to generate new one
                sponsor.setCode("SS" + makeAutoGenerateNumberService.numberAutoGen(null).toString());
            } else {
                System.out.println("last sponsor not null");
                //if there is sponsor in db need to get that sponsor's code and increase its value
                String previousCode = DBSponsor.getCode().substring(2);
                sponsor.setCode("SS" + makeAutoGenerateNumberService.numberAutoGen(previousCode).toString());
            }
            //send welcome message and email
            if (sponsor.getEmail() != null) {
                //  emailService.sendEmail(sponsor.getEmail(), "Welcome Message", "Welcome to Kmart Super...");
            }
        }
        redirectAttributes.addFlashAttribute("sponsorDetail",
                sponsorService.persist(sponsor));
        return "redirect:/sponsor";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        return commonThings(model, sponsorService.findById(id), false);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        sponsorService.delete(id);
        return "redirect:/sponsor";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("sponsorDetail", sponsorService.findById(id));
        return "sponsor/sponsor-detail";
    }
}
