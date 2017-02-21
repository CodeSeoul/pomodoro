const DEFAULT_SECONDS = 5;

let seconds = DEFAULT_SECONDS;
let timer;
let currentTime = document.getElementById("currentTime");
let isTimerOn = false;
let pomodoros = 0;


function start(){
  if (isTimerOn) return;

  isTimerOn = true;
  timer = setInterval(() => {
    if(seconds === 0){
       seconds= DEFAULT_SECONDS + 1;
       updatePomodoro();
    } else {
        seconds--;
        currentTime.innerHTML = formatTime(seconds);
    }
  }, 1000);
}

function pause(){
  isTimerOn = false;
  clearInterval(timer);
}

function stop(){
  seconds = DEFAULT_SECONDS;
  clearInterval(timer);
  currentTime.innerHTML = formatTime(seconds);
}

function updatePomodoro(){
  pomodoros++;
  document.getElementById("pomodoros").innerHTML = pomodoros;
}

document.getElementById('startBtn').addEventListener('click', start);
document.getElementById('stopBtn').addEventListener('click', stop);
document.getElementById('pauseBtn').addEventListener('click', pause);
