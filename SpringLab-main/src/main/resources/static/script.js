const button = document.querySelector('#button');
const datepicker = document.querySelector('#datepicker');
const elements = document.querySelectorAll("input, select");
const message = document.querySelector("#message");

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
        
        $('#button').click(function () {
            var inital = $('#initial-time').val();
            var final = $('#final-time').val();
            if (inital == '' || final == '') {
                message.innerText = "Please, set a time"
                return false;
            } else {
                $('form').submit();
            }
        });
    });




    function minTime() {
        if (datepicker.value == null || datepicker.value != nowDate) {
            return null;
        } else {
            return (now.getHours() + ":" + now.getMinutes())
        }
    }
}

function verify() {
    if (!datepicker.value) {
        message.innerText = "Put date, first";
    }
}

function allow() {
    message.innerText = "";
}

getDate();