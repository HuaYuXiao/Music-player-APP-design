package com.example.ver1;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class frag extends Fragment {
  private View view;
  //创建歌曲的String数组和歌⼿图⽚的int数组
  public String[] name={"只因你太美","幻昼（DJ版）","waitwaitwait","情⼈","没有意外"};
  public static int[] icons={R.drawable.music0,R.drawable.music1,R.drawable.music2,R.drawable.music3,R.drawable.music4};
  @Override
  public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
  //绑定布局，只不过这⾥是⽤inflate()⽅法
  view=inflater.inflate(R.layout.music_list,null);
  //创建listView列表并且绑定控件
  ListView listView=view.findViewById(R.id.lv);
  //实例化⼀个适配器
  MyBaseAdapter adapter=new MyBaseAdapter();
  //列表设置适配器
  listView.setAdapter(adapter);
  //列表元素的点击监听器
  listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
  //创建Intent对象，参数就是从frag1跳转到MusicActivity
  Intent intent=new Intent(frag.this.getContext(), MusicActivity.class);
  //将歌曲名和歌曲的下标存⼊Intent对象
  intent.putExtra("name",name[position]);
  intent.putExtra("position",String.valueOf(position));
  //开始跳转
  startActivity(intent);
}
});
return view;
}
  
//这⾥是创建⼀个⾃定义适配器，可以作为模板
class MyBaseAdapter extends BaseAdapter{
  @Override
  public int getCount(){return name.length;}
  @Override
  public Object getItem(int i){return name[i];}
  @Override
  public long getItemId(int i){return i;}
  @Override
  public View getView(int i ,View convertView, ViewGroup parent) {
    //绑定好VIew，然后绑定控件
    View view=View.inflate(frag.this.getContext(),R.layout.item_layout,null);
    TextView tv_name=view.findViewById(R.id.item_name);
    ImageView iv=view.findViewById(R.id.iv);
    //设置控件显⽰的内容，就是获取的歌曲名和歌⼿图⽚
    tv_name.setText(name[i]);
    iv.setImageResource(icons[i]);
    return view;
  }
 }
}
