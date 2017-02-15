let seconds = 25 * 60;
let timer;
let currentTime = document.getElementById("currentTime");

function start(){
  timer = setInterval(function (){
    seconds--;
    currentTime.innerHTML = formatTime(seconds);
  }, 1000);
}

function pause(){
  clearInterval(timer);
}

function stop(){
  seconds = 25 * 60;
  clearInterval(timer);
  currentTime.innerHTML = formatTime(seconds);
}

document.getElementById('startBtn').addEventListener('click', start);
document.getElementById('stopBtn').addEventListener('click', stop);
document.getElementById('pauseBtn').addEventListener('click', pause);
