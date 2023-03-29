const button = document.querySelector('#button');
const datepicker = document.querySelector('#datepicker');
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
        
        $('#button').click(function (event) {
            event.preventDefault();
            if ($('#initial-time').val() == '' || $('#final-time') == '' || $('#inputLab').val() == null || $('#inputSubject').val() == null) {
                $('#message').text("Please, check all the inputs");
                console.log($('#inputLab').val());
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
        button.disabled = true;
    }
}

function allow() {
    message.innerText = "";
    button.disabled = false;
}

getDate();