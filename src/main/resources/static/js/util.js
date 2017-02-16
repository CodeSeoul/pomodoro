function formatTime(time){
  let min = Math.floor(time/60);
  let sec = time%60;
  return zeroFill(min) + ":" + zeroFill(sec);
}

function zeroFill(time){
  if(time < 10){
    return "0" + time;
  }
  return time;
}
