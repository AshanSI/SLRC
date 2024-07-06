package lk.rupavahini.PPUManagement.asset.booking.controller;




import jdk.jfr.ContentType;
import lk.rupavahini.PPUManagement.asset.booking.entity.Booking;
import lk.rupavahini.PPUManagement.asset.booking.service.BookingService;
import lk.rupavahini.PPUManagement.util.service.MakeAutoGenerateNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;
    private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;

    @Autowired
    public BookingController(BookingService bookingService, MakeAutoGenerateNumberService makeAutoGenerateNumberService) {
        this.bookingService = bookingService;
        this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
    }

    private String commonThings(Model model, Booking booking, Boolean addState) {
        model.addAttribute("booking", booking);
        /*model.addAttribute("addStatus", addState);*/
        return "booking/selectable";
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("booking", bookingService.findAll());
        return "booking/booking";
    }


    @GetMapping("/selectable")
    public String addForm(Model model) {
        return commonThings(model, new Booking(), true);
    }

    @PostMapping("/selectable")
    public void abc( Booking booking ){
        System.out.println(booking);



    }

  /*  @PostMapping(value = {"/save", "/update"})
    public String persist(@Valid @ModelAttribute Booking booking, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            return commonThings(model, booking, true);
        }

        //if booking has id that booking is not a new booking
        if (booking.getId() == null) {
            //if there is not booking in db
            Booking DBSupplier = bookingService.lastBooking();

            //get booking SCode
            if (booking.getSCode() != null) {
                //  emailService.sendEmail(booking.getEmail(), "Welcome Message", "Welcome to Kmart Super...");
            }

           *//* //get Stdudio Location
            if (booking.getbookingName() != null) {
                //  emailService.sendEmail(booking.getEmail(), "Welcome Message", "Welcome to Kmart Super...");
            }*//*

           *//* if (booking.getId() == null) {
                //if there is not booking in db
                booking DBbooking = bookingService.lastbooking();

                if (DBbooking == null) {
                    //need to generate new one
                    booking.setCode("St" + makeAutoGenerateNumberService.numberAutoGen(null).toString());
                } else {
                    System.out.println("last booking not null");
                    //if there is booking in db need to get that booking's code and increase its value
                    String previousCode = DBbooking.getCode().substring(2);
                    booking.setCode("St" + makeAutoGenerateNumberService.numberAutoGen(previousCode).toString());
                }

            }*//*
        }
        redirectAttributes.addFlashAttribute("bookingDetail",
                bookingService.persist(booking));
        return "redirect:/booking";
    }

*/

  /*  @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        return commonThings(model, bookingService.findById(id), false);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        bookingService.delete(id);
        return "redirect:/booking";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("bookingDetail", bookingService.findById(id));
        return "booking/booking-detail";
    }*/
}
