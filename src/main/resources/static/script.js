function getDate() {
    var now = new Date();
    var year = now.getFullYear();
    var month = (now.getMonth() + 1).toString().padStart(2, '0');
    var day = now.getDate().toString().padStart(2, '0');
    var nowDate = `${year}-${month}-${day}`;
    datepicker.min = nowDate;

    $(document).ready(function () {
        flatpickr(".flatpickr-time", {
            enableTime: true,
            noCalendar: true,
            dateFormat: "H:i",
            minTime: minTime(),
            static: true,
            time_24hr: true,
        });
    });

    function minTime() {
        if (document.querySelector("#datepicker").value == null) {
            return null;
        } else {
            document.querySelector("#message").innerText = "";
            return (now.getHours() + ":" + now.getMinutes())
        }
    }
}

function verify() {
    if (!document.querySelector("#datepicker").value) {
        document.querySelector("#message").innerText = "Set the date, first!";
    }
}

