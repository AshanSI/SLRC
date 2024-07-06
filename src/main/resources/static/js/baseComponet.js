const baseURL = "http://localhost:8084/";

const downloadBaseUrl = baseURL + "downloadFile/";

function getSchoolImagePath(imageLocation) {
    return downloadBaseUrl + imageLocation;
}

const ACTION_TYPES = {
    ADD: 'add',
    UPDATE: 'update',
    REMOVE: 'remove',
    SEARCH: 'search'
};

const TOAST_TYPE = {
    SUCCESS: 'SUCCESS',
    WARNING: 'WARNING',
    DANGER: 'DANGER',
    INFO: 'INFO'
};

const CHART_TYPE = {
    BAR: 'BAR_CHART',
    PIE: 'PIE_CHART',
    LINE: 'LINE_CHART'
};

const IMAGE_TYPE = {
    JPEG: 'jpg',
    PNG: 'png'
};

function getCurrentTime() {
    let todayTime = new Date().getHours() + '-';
    todayTime = todayTime + new Date().getMinutes() + '-';
    return todayTime = todayTime + new Date().getMilliseconds();
}

function getTodayDate() {
    let todayDate = new Date().getFullYear() + '-';
    todayDate = todayDate + new Date().getMonth() + '-';
    return todayDate = todayDate + new Date().getDate() + ' ';
}

/**
 * this method for show warning toast on top right
 *
 * @param toastTitle
 * @param description
 */
function showWarningToast(toastTitle, description) {
    toastr.warning(toastTitle, description, {
        "positionClass": "toast-top-right",
        timeOut: 5000,
        "closeButton": true,
        "debug": false,
        "newestOnTop": true,
        "progressBar": true,
        "preventDuplicates": true,
        "onclick": null,
        "showDuration": "300",
        "hideDuration": "1000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut",
        "tapToDismiss": false

    })
}

/**
 * this method for show danger toast on top right
 *
 * @param toastTitle
 * @param description
 */
function showDangerToast(toastTitle, description) {
    toastr.error(toastTitle, description, {
        "positionClass": "toast-top-right",
        timeOut: 5000,
        "closeButton": true,
        "debug": false,
        "newestOnTop": true,
        "progressBar": true,
        "preventDuplicates": true,
        "onclick": null,
        "showDuration": "300",
        "hideDuration": "1000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut",
        "tapToDismiss": false

    })
}

/**
 * this method for show info toast on top right
 *
 * @param toastTitle
 * @param description
 */
function showInfoToast(toastTitle, description) {
    toastr.info(toastTitle, description, {
        "positionClass": "toast-top-right",
        timeOut: 5000,
        "closeButton": true,
        "debug": false,
        "newestOnTop": true,
        "progressBar": true,
        "preventDuplicates": true,
        "onclick": null,
        "showDuration": "300",
        "hideDuration": "1000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut",
        "tapToDismiss": false

    })
}

/**
 * this method for show successful toast on top right
 *
 * @param toastTitle
 * @param description
 */
function showSuccessToast(toastTitle, description) {
    toastr.success(toastTitle, description, {
        timeOut: 5000,
        "closeButton": true,
        "debug": false,
        "newestOnTop": true,
        "progressBar": true,
        "positionClass": "toast-top-right",
        "preventDuplicates": true,
        "onclick": null,
        "showDuration": "300",
        "hideDuration": "1000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut",
        "tapToDismiss": false
    })
}

/**
 * this method for show toast by toast type
 *
 * @param TOAST_TYPE
 * @param toastTitle
 * @param description
 */
function showToast(TOAST_TYPE, toastTitle, description) {
    switch (TOAST_TYPE) {
        case 'SUCCESS':
            showSuccessToast(toastTitle, description);
            break;
        case 'WARNING':
            showWarningToast(toastTitle, description);
            break;
        case 'DANGER':
            showDangerToast(toastTitle, description);
            break;
        case 'INFO':
            showInfoToast(toastTitle, description);
            break;
        default:
            break;
    }
}


//Chart JS Base Components (Base Functions) ---------------------------------------------------------

/**
 * this method for add data into defined chart
 *
 * @param chart
 * @param label
 * @param data
 */
function addData(chart, label, data) {
    chart.data.labels.push(label);
    chart.data.datasets.forEach((dataset) => {
        dataset.data.push(data);
    });

    chart.update();
}

/**
 * this method into remove the last data from chart
 *
 * @param chart
 */
function removeData(chart) {
    chart.data.labels.pop();
    chart.data.datasets.forEach((dataset) => {
        dataset.data.pop();
    });
    chart.update();
}


const color = [
    "#ef5350", "#26a69a", "#ec407a", "#66bb6a", "#ffa726", "#9ccc65", "#7e57c2", "#42a5f5", "#ab47bc", "#ffee58", "#5c6bc0", "#26c6da", "#8d6e63", "#d4e157", "#29b6f6", "#ffca28", "#ff7043", "#78909c",
    "#ef5350", "#26a69a", "#ec407a", "#66bb6a", "#ffa726", "#9ccc65", "#7e57c2", "#42a5f5", "#ab47bc", "#ffee58", "#5c6bc0", "#26c6da", "#8d6e63", "#d4e157", "#29b6f6", "#ffca28", "#ff7043", "#78909c",
    "#ef5350", "#26a69a", "#ec407a", "#66bb6a", "#ffa726", "#9ccc65", "#7e57c2", "#42a5f5", "#ab47bc", "#ffee58", "#5c6bc0", "#26c6da", "#8d6e63", "#d4e157", "#29b6f6", "#ffca28", "#ff7043", "#78909c",
    "#ef5350", "#26a69a", "#ec407a", "#66bb6a", "#ffa726", "#9ccc65", "#7e57c2", "#42a5f5", "#ab47bc", "#ffee58", "#5c6bc0", "#26c6da", "#8d6e63", "#d4e157", "#29b6f6", "#ffca28", "#ff7043", "#78909c",
    "#ef5350", "#26a69a", "#ec407a", "#66bb6a", "#ffa726", "#9ccc65", "#7e57c2", "#42a5f5", "#ab47bc", "#ffee58", "#5c6bc0", "#26c6da", "#8d6e63", "#d4e157", "#29b6f6", "#ffca28", "#ff7043", "#78909c",
    "#ef5350", "#26a69a", "#ec407a", "#66bb6a", "#ffa726", "#9ccc65", "#7e57c2", "#42a5f5", "#ab47bc", "#ffee58", "#5c6bc0", "#26c6da", "#8d6e63", "#d4e157", "#29b6f6", "#ffca28", "#ff7043", "#78909c",
    "#ef5350", "#26a69a", "#ec407a", "#66bb6a", "#ffa726", "#9ccc65", "#7e57c2", "#42a5f5", "#ab47bc", "#ffee58", "#5c6bc0", "#26c6da", "#8d6e63", "#d4e157", "#29b6f6", "#ffca28", "#ff7043", "#78909c",
    "#ef5350", "#26a69a", "#ec407a", "#66bb6a", "#ffa726", "#9ccc65", "#7e57c2", "#42a5f5", "#ab47bc", "#ffee58", "#5c6bc0", "#26c6da", "#8d6e63", "#d4e157", "#29b6f6", "#ffca28", "#ff7043", "#78909c",
    "#ef5350", "#26a69a", "#ec407a", "#66bb6a", "#ffa726", "#9ccc65", "#7e57c2", "#42a5f5", "#ab47bc", "#ffee58", "#5c6bc0", "#26c6da", "#8d6e63", "#d4e157", "#29b6f6", "#ffca28", "#ff7043", "#78909c",
    "#ef5350", "#26a69a", "#ec407a", "#66bb6a", "#ffa726", "#9ccc65", "#7e57c2", "#42a5f5", "#ab47bc", "#ffee58", "#5c6bc0", "#26c6da", "#8d6e63", "#d4e157", "#29b6f6", "#ffca28", "#ff7043", "#78909c",
    "#ef5350", "#26a69a", "#ec407a", "#66bb6a", "#ffa726", "#9ccc65", "#7e57c2", "#42a5f5", "#ab47bc", "#ffee58", "#5c6bc0", "#26c6da", "#8d6e63", "#d4e157", "#29b6f6", "#ffca28", "#ff7043", "#78909c",
    "#ef5350", "#26a69a", "#ec407a", "#66bb6a", "#ffa726", "#9ccc65", "#7e57c2", "#42a5f5", "#ab47bc", "#ffee58", "#5c6bc0", "#26c6da", "#8d6e63", "#d4e157", "#29b6f6", "#ffca28", "#ff7043", "#78909c",
    "#ef5350", "#26a69a", "#ec407a", "#66bb6a", "#ffa726", "#9ccc65", "#7e57c2", "#42a5f5", "#ab47bc", "#ffee58", "#5c6bc0", "#26c6da", "#8d6e63", "#d4e157", "#29b6f6", "#ffca28", "#ff7043", "#78909c",
    "#ef5350", "#26a69a", "#ec407a", "#66bb6a", "#ffa726", "#9ccc65", "#7e57c2", "#42a5f5", "#ab47bc", "#ffee58", "#5c6bc0", "#26c6da", "#8d6e63", "#d4e157", "#29b6f6", "#ffca28", "#ff7043", "#78909c"
];

function getColorArr() {
    return color;
}
