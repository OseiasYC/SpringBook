const button = document.querySelector("#button");
const datepicker = document.querySelector("#datepicker");
const message = document.querySelector("#message");
const initial = document.querySelector("#initial-time");
const final = document.querySelector("#final-time");

function getDate() {
  var now = new Date();
  var year = now.getFullYear();
  var month = (now.getMonth() + 1).toString().padStart(2, "0");
  var day = now.getDate().toString().padStart(2, "0");
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
    if (datepicker.value == null || datepicker.value != nowDate) {
      return null;
    } else {
      return now.getHours() + ":" + now.getMinutes();
    }
  }
}

function finalTime() {
  flatpickr("#final-time", {
    enableTime: true,
    noCalendar: true,
    dateFormat: "H:i",
    minTime: initial.value,
    static: true,
    time_24hr: true,
  });
}

//Checker
$("#button").click(function (event) {
  event.preventDefault();
  const selectedInitialTime = new Date(
    datepicker.value + "T" + initial.value + ":00"
  );
  const selectedFinalTime = new Date(
    datepicker.value + "T" + initial.value + ":00"
  );
  var now = new Date();

  if (
    !initial.value ||
    !final.value ||
    !$("#inputLab").val() ||
    !$("#inputSubject").val() ||
    !datepicker.value
  ) {
    $("#message").text("Please, check all the inputs");
  } else {
    if (initial.value || final.value) {
      if (
        selectedInitialTime < now.getTime() ||
        selectedFinalTime < now.getTime()
      ) {
        $("#message").text("You can't select past time");
      } else {
        $("form").submit();
      }
    }
  }
});

$("#form-home").removeClass("hidden");

getDate();