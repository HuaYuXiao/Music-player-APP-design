//handler机制，可以理解为线程间的通信，我获取到⼀个信息，然后把这个信息告诉你，就这么简单
public static Handler handler=new Handler(){//创建消息处理器对象
  //在主线程中处理从⼦线程发送过来的消息
  @SuppressLint("HandlerLeak")
  @Override
  public void handleMessage(Message msg){
    Bundle bundle=msg.getData();//获取从⼦线程发送过来的⾳乐播放进度
    //获取当前进度currentPosition和总时⻓duration
    int duration=bundle.getInt("duration");
    int currentPosition=bundle.getInt("currentPosition");
    //对进度条进⾏设置
    sb.setMax(duration);
    sb.setProgress(currentPosition);
    //歌曲是多少分钟多少秒钟
    int minute=duration/1000/60;
    int second=duration/1000%60;
    String strMinute=null;
    String strSecond=null;
    //如果歌曲的时间中的分钟⼩于10
    if(minute<10){
      //在分钟的前⾯加⼀个0
      strMinute="0"+minute;
    }else{
      strMinute=minute+"";
    }
    //如果歌曲中的秒钟⼩于10
    if (second<10){
      //在秒钟前⾯加⼀个0
      strSecond="0"+second;
    }else{
      strSecond=second+"";
    }
    //这⾥就显⽰了歌曲总时⻓
    tv_total.setText(strMinute+":"+strSecond);
    //歌曲当前播放时⻓
    minute=currentPosition/1000/60;
    second=currentPosition/1000%60;
    //如果歌曲的时间中的分钟⼩于10
    if(minute<10){
      //在分钟的前⾯加⼀个0
      strMinute="0"+minute;
    }else{
      strMinute=minute+" ";
    }
    //如果歌曲中的秒钟⼩于10
    if (second<10){
      //在秒钟前⾯加⼀个0
      strSecond="0"+second;
    }else{
      strSecond=second+" ";
    }
    //显⽰当前歌曲已经播放的时间
    tv_progress.setText(strMinute+":"+strSecond);
  }
};
