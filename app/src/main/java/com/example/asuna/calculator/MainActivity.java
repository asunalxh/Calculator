package com.example.asuna.calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.StringBuilder;
import java.math.BigDecimal;
import java.sql.BatchUpdateException;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Vector;

import static java.lang.Math.cos;
import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.tan;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private boolean flag=false;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Configuration configuration=this.getResources().getConfiguration();
        textView=(TextView)findViewById(R.id.flag);
        int ori=configuration.orientation;
        if(ori==configuration.ORIENTATION_LANDSCAPE){
            Button jiecheng=(Button)findViewById(R.id.jiecheng);
            Button x2= (Button) findViewById(R.id.x2);
            Button x3= (Button) findViewById(R.id.x3);
            Button xy=(Button) findViewById(R.id.xy);
            Button x_2=(Button) findViewById(R.id.x_2);
            Button x_y=(Button) findViewById(R.id.x_y);
            Button pai=(Button)findViewById(R.id.π);
            Button ln=(Button)findViewById(R.id.ln);
            Button log=(Button)findViewById(R.id.log);
            Button e=(Button)findViewById(R.id.e);
            Button sin=(Button)findViewById(R.id.sin);
            Button cos=(Button)findViewById(R.id.cos);
            Button tan=(Button)findViewById(R.id.tan);
            jiecheng.setOnClickListener(this);
            x2.setOnClickListener(this);
            x3.setOnClickListener(this);
            xy.setOnClickListener(this);
            x_2.setOnClickListener(this);
            x_y.setOnClickListener(this);
            pai.setOnClickListener(this);
            ln.setOnClickListener(this);
            log.setOnClickListener(this);
            e.setOnClickListener(this);
            sin.setOnClickListener(this);
            cos.setOnClickListener(this);
            tan.setOnClickListener(this);
        }
        editText = (EditText) findViewById(R.id.edit);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//自动隐藏标题栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            editText.setShowSoftInputOnFocus(false);
        }//取消点击弹出输入法
        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button plus = (Button) findViewById(R.id.plus);
        Button minus = (Button) findViewById(R.id.minus);
        Button multiply = (Button) findViewById(R.id.multiply);
        Button divide = (Button) findViewById(R.id.divide);
        ImageButton remove = (ImageButton) findViewById(R.id.remove);
        Button k1 = (Button) findViewById(R.id.k1);
        Button k2 = (Button) findViewById(R.id.k2);
        Button equal = (Button) findViewById(R.id.equal);
        Button c=(Button)findViewById(R.id.c);
        Button point=(Button)findViewById(R.id.point);
        Button percent=(Button)findViewById(R.id.percent);
        final TextView flag=(TextView)findViewById(R.id.flag);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        k1.setOnClickListener(this);
        k2.setOnClickListener(this);
        equal.setOnClickListener(this);
        c.setOnClickListener(this);
        point.setOnClickListener(this);
        percent.setOnClickListener(this);
        remove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView text=(TextView)findViewById(R.id.text);
        Editable content= editText.getText();
        int position=editText.getSelectionStart();
        switch (v.getId()){
            case R.id.button0:
                content.insert(position,"0");
                break;
            case R.id.button1:
                content.insert(position,"1");
                break;
            case R.id.button2:
                content.insert(position,"2");
                break;
            case R.id.button3:
                content.insert(position,"3");
                break;
            case R.id.button4:
                content.insert(position,"4");
                break;
            case R.id.button5:
                content.insert(position,"5");
                break;
            case R.id.button6:
                content.insert(position,"6");
                break;
            case R.id.button7:
                content.insert(position,"7");
                break;
            case R.id.button8:
                content.insert(position,"8");
                break;
            case R.id.button9:
                content.insert(position,"9");
                break;
            case R.id.plus:
                if(position>=1){
                    char x=content.charAt(position-1);
                    if(x=='-'||x=='+'||x=='×'||x=='÷')
                        content.replace(position-1,position,"+");
                    else if(x!='.')
                        content.insert(position,"+");
                }
                break;
            case R.id.minus:
                if(position==0)
                    content.insert(0,"-");
                else if(position>=1){
                    char x=content.charAt(position-1);
                    if(x=='+'||x=='-'||x=='×'||x=='÷')
                        content.replace(position-1,position,"-");
                    else if(x!='.')
                        content.insert(position,"-");
                }
                break;
            case R.id.multiply:
                if(position>=1){
                    char x=content.charAt(position-1);
                    if(x=='+'||x=='-'||x=='×'||x=='÷')
                        content.replace(position-1,position,"×");
                    else if(x!='.')
                        content.insert(position,"×");
                }
                break;
            case R.id.divide:
                if(position>=1){
                    char x=content.charAt(position-1);
                    if(x=='+'||x=='-'||x=='×'||x=='÷')
                        content.replace(position-1,position,"÷");
                    else if(x!='.')
                        content.insert(position,"÷");
                }
                break;
            case R.id.remove:
                if(position>=1){
                    char x=content.charAt(position-1);
                    if('('==x){
                        if(position>=3) {
                            StringBuffer stringbuilder = new StringBuffer();
                            stringbuilder.append(content.charAt(position - 3));
                            stringbuilder.append(content.charAt(position - 2));
                            if (stringbuilder.toString().equals("ln")) {
                                content.delete(position - 3, position);
                                break;
                            } else if (stringbuilder.toString().equals("og") || stringbuilder.toString().equals("in") || stringbuilder.toString().equals("os") || stringbuilder.toString().equals("an")) {
                                content.delete(position - 4, position);
                                break;
                            }
                        }
                    }
                    if(x=='c'||x=='t')
                        content.delete(position-1,position+3);
                    else if(x=='l'){
                        char n=content.charAt(position);
                        if(n=='o')
                            content.delete(position-1,position+3);
                        else if(n=='n')
                            content.delete(position-1,position+2);
                    }
                    else if(x=='s'){
                        if(position<=content.length()-2){
                            char n=content.charAt(position);
                            if(n=='i'){
                                content.delete(position-1,position+3);
                                break;
                            }
                        }
                        if(position>=3){
                            char n=content.charAt(position-2);
                            if(n=='o'){
                                content.delete(position-3,position+1);
                            }
                        }
                    }
                    else if(x=='i'||x=='a'||x=='o')
                        content.delete(position-2,position+2);
                    else if(x=='g')
                        content.delete(position-3,position+1);
                    else if(x=='n'){
                        char n=content.charAt(position-2);
                        if(n=='a'||n=='i')
                            content.delete(position-3,position+1);
                        else if(n=='l')
                            content.delete(position-2,position+1);
                    }
                    else content.delete(position-1,position);
                }
                break;
            case R.id.c:
                content.clear();
                break;
            case R.id.k1:
                content.insert(position,"(");
                break;
            case R.id.k2:
                content.insert(position,")");
                break;
            case R.id.point:
                boolean f=true;
                for(int i=position-1;i>=0;i--){
                    char x=content.charAt(i);
                    if(x>='0'&&x<='9')
                        continue;
                    else if(x=='.'){
                        f=false;
                        break;
                    }
                    else break;
                }
                for(int i=position+1;i<content.length();i++){
                    char x=content.charAt(i);
                    if(x>='0'&&x<='9')
                        continue;
                    else if(x=='.'){
                        f=false;
                        break;
                    }
                    else break;
                }
                if(f){
                    content.insert(position,".");
                }
                break;
            case R.id.percent:
                if(position>=1)
                content.insert(position,"%");
                break;
            case R.id.jiecheng:
                if(position>=1)
                content.insert(position,"!");
                break;
            case R.id.x2:
                if(position>=1){
                    content.insert(position,"^(2)");
                }
                break;
            case R.id.x3:
                if(position>=1){
                        content.insert(position,"^(3)");
                }break;
            case R.id.xy:
                if(position>=1){
                        content.insert(position,"^(");
                }
                break;
            case R.id.x_2:
                if(position>=1){
                        content.insert(position,"^(1÷2)");
                }
                break;
            case R.id.x_y:
                if(position>=1){
                        content.insert(position,"^(1÷");
                }
                break;
            case R.id.e:
                content.insert(position,"e");
                break;
            case R.id.ln:
                content.insert(position,"ln(");
                break;
            case R.id.log:
                content.insert(position,"log(");
                break;
            case R.id.π:
                content.insert(position,"π");
                break;
            case R.id.sin:
                content.insert(position,"sin(");
                break;
            case R.id.cos:
                content.insert(position,"cos(");
                break;
            case R.id.tan:
                content.insert(position,"tan(");
                break;
            case R.id.equal:
                if(textView.getText().toString().length()>0)
                    return;
                //压栈
                Stack<BigDecimal> number=new Stack<>();//数字栈;
                Stack<BigDecimal> numbers=new Stack<>();//辅助数字栈
                Stack<BigDecimal> number_s=new Stack<>();
                Stack<Character> symbol_s=new Stack<>();
                Stack<Character> symbol=new Stack<Character>();//符号栈
                Stack<Character> symbols=new Stack<Character>();//辅助符号栈
                StringBuffer num=new StringBuffer();
                StringBuffer alt=new StringBuffer();
                for(int i=0;i<content.length();i++){
                    char x=content.charAt(i);
                    if(i==0&&(x=='-'||x=='+')){
                        numbers.push(new BigDecimal("0"));
                        symbols.push(x);
                        continue;
                    }
                    if((x>='0'&&x<='9'||x=='.')){
                        num.append(x);
                        continue;
                    }
                    else {
                        if(!num.toString().equals("")) {
                            numbers.push(new BigDecimal(num.toString()));
                            num = new StringBuffer();
                        }
                    }
                    if(x=='('||x==')'||x=='×'||x=='÷'||x=='%'||x=='^'||x=='!') {
                        symbols.push(x);
                        continue;
                    }
                    else if(x=='+'||x=='-'){
                        if(i>=1){
                            char n=content.charAt(i-1);
                            if(n=='(')
                                numbers.push(new BigDecimal("0"));
                        }
                        symbols.push(x);
                    }
                    else if(x=='π') {
                        if(i>=1){
                            char n=content.charAt(i-1);
                            if((n>='0'&&n<='9')||n=='e'||n=='π')
                                symbols.push('×');
                        }
                        numbers.push(new BigDecimal("3.1415926535897932384626433832795028841971"));
                    }
                    else if(x=='e') {
                        if(i>=1){
                            char n=content.charAt(i-1);
                            if((n>='0'&&n<='9')||n=='π'||n=='e')
                                symbols.push('×');
                        }
                        numbers.push(new BigDecimal("2.7182818284590452353602874713526624977572"));
                    }
                    else if(x>='a'&&x<='z'){
                        alt.append(x);
                        if(alt.toString().equals("sin")){
                            if(i>=3){
                                char n=content.charAt(i-3);
                                if(n>='0'&&n<='9')
                                    symbols.push('×');
                            }
                            symbols.push('i');
                            alt=new StringBuffer();
                        }
                        else if(alt.toString().equals("cos")){
                            if(i>=3){
                                char n=content.charAt(i-3);
                                if(n>='0'&&n<='9')
                                    symbols.push('×');
                            }
                            symbols.push('o');
                            alt=new StringBuffer();
                        }
                        else if(alt.toString().equals("tan")){
                            if(i>=3){
                                char n=content.charAt(i-3);
                                if(n>='0'&&n<='9')
                                    symbols.push('×');
                            }
                            symbols.push('a');
                            alt=new StringBuffer();
                        }
                        else if(alt.toString().equals("ln")){
                            if(i>=2){
                                char n=content.charAt(i-3);
                                if(n>='0'&&n<='9')
                                    symbols.push('×');
                            }
                            symbols.push('n');
                            alt=new StringBuffer();
                        }
                        else if(alt.toString().equals("log")){
                            if(i>=3){
                                char n=content.charAt(i-3);
                                if(n>='0'&&n<='9')
                                    symbols.push('×');
                            }
                            symbols.push('g');
                            alt=new StringBuffer();
                        }
                    }
                }
                if(num.length()>0)
                    numbers.push(new BigDecimal(num.toString()));

                //计算
                while(!numbers.empty()){
                    number.push(numbers.peek());
                    numbers.pop();
                }
                while(!symbols.empty()){
                    symbol.push(symbols.peek());
                    symbols.pop();
                }
                while(!symbol.empty()){
                    char x=symbol.peek();
                    symbol.pop();
                    if(x=='(') {
                        symbols.push(x);
                        continue;
                    }
                    if(x==')'){
                        while (!symbols.empty()){
                            char a=symbols.peek();
                            symbols.pop();
                            if(a=='(')
                                break;
                            BigDecimal b=numbers.peek();
                            numbers.pop();
                            number_s.push(b);
                            symbol_s.push(a);
                        }
                        while(!number_s.empty()&&!symbol_s.empty()){
                            number.push(number_s.peek());
                            number_s.pop();
                            symbol.push(symbol_s.peek());
                            symbol_s.pop();
                        }
                        continue;
                    }
                    if(symbol.empty()&&symbols.empty()){
                        if(x=='+'||x=='-'||x=='×'||x=='÷'||x=='^'){
                            BigDecimal a=number.peek();number.pop();
                            BigDecimal b=number.peek();number.pop();
                            BigDecimal answer=new BigDecimal("0");
                            switch (x){
                                case '+':answer=a.add(b);break;
                                case '-':answer=a.subtract(b);break;
                                case '×':answer=a.multiply(b);break;
                                case '÷':
                                    if(b.compareTo(new BigDecimal("0"))==0){
                                        textView.setText("错误");
                                        return;
                                    }
                                    answer=a.divide(b,17,BigDecimal.ROUND_HALF_UP);
                                    break;
                                case '^': answer=new BigDecimal(String.valueOf(pow(a.doubleValue(),b.doubleValue())));
                                    break;
                            }
                            number.push(answer);
                            if(symbol_s.empty())
                                break;
                            while(!number_s.empty()&&!symbol_s.empty()){
                                number.push(number_s.peek());
                                number_s.pop();
                                symbol.push(symbol_s.peek());
                                symbol_s.pop();
                            }
                            continue;
                        }
                        else if(x=='!'||x=='%'||x=='i'||x=='o'||x=='a'||x=='n'||x=='g'){
                            BigDecimal a=number.peek();number.pop();
                            BigDecimal answer=new BigDecimal("1");
                            switch (x){
                                case '!':
                                    if(a.doubleValue()%1>0||a.doubleValue()<0){
                                        textView.setText("错误");
                                        return;
                                    }
                                    for(int i=1;i<=a.intValue();i++)
                                        answer=answer.multiply(new BigDecimal(String.valueOf(i)));
                                    break;
                                case '%':answer=a.divide(new BigDecimal("100"));break;
                                case 'i':answer=new BigDecimal(String.valueOf(sin(a.doubleValue())));break;
                                case 'o':answer=new BigDecimal(String.valueOf(cos(a.doubleValue())));break;
                                case 'a':answer=new BigDecimal(String.valueOf(tan(a.doubleValue())));break;
                                case 'n':answer=new BigDecimal(String.valueOf(log(a.doubleValue())));break;
                                case 'g':answer=new BigDecimal(String.valueOf(log10(a.doubleValue())));
                            }
                            number.push(answer);
                            if(symbol_s.empty())
                                break;
                            while(!number_s.empty()&&!symbol_s.empty()){
                                number.push(number_s.peek());
                                number_s.pop();
                                symbol.push(symbol_s.peek());
                                symbol_s.pop();
                            }
                            continue;
                        }
                    }
                    char y=symbol.peek();symbol.pop();
                    if(y=='('){
                        symbols.push(y);
                        symbols.push(x);
                        numbers.push(number.peek());
                        number.pop();
                        while(!symbol_s.empty()){
                            numbers.push(number_s.peek());
                            number_s.pop();
                            symbols.push(symbol_s.peek());
                            symbol_s.pop();
                        }
                        continue;
                    }
                    if(x=='!'||x=='%'||x=='i'||x=='o'||x=='a'||x=='n'||x=='g'){
                        BigDecimal a=number.peek();number.pop();
                        BigDecimal answer=new BigDecimal("1");
                        switch (x){
                            case '!':
                                if(a.doubleValue()%1>0||a.doubleValue()<0){
                                    textView.setText("错误");
                                    return;
                                }
                                for(int i=1;i<=a.intValue();i++)
                                    answer=answer.multiply(new BigDecimal(String.valueOf(i)));
                                break;
                            case '%':answer=a.divide(new BigDecimal("100"));break;
                            case 'i':answer=new BigDecimal(String.valueOf(sin(a.doubleValue())));break;
                            case 'o':answer=new BigDecimal(String.valueOf(cos(a.doubleValue())));break;
                            case 'a':answer=new BigDecimal(String.valueOf(tan(a.doubleValue())));break;
                            case 'n':answer=new BigDecimal(String.valueOf(log(a.doubleValue())));break;
                            case 'g':answer=new BigDecimal(String.valueOf(log10(a.doubleValue())));
                        }
                        number.push(answer);
                        symbol.push(y);
                        while(!number_s.empty()&&!symbol_s.empty()){
                            number.push(number_s.peek());
                            number_s.pop();
                            symbol.push(symbol_s.peek());
                            symbol_s.pop();
                        }
                        continue;
                    }
                    else if(x=='^'){
                        if(y=='!'||y=='%'||y=='i'||y=='o'||y=='a'||y=='n'||y=='g'){
                            number_s.push(number.peek());
                            number.pop();
                            symbol_s.push(x);
                            symbol.push(y);
                            continue;
                        }
                        BigDecimal a=number.peek();number.pop();
                        BigDecimal b=number.peek();number.pop();
                        number.push(new BigDecimal(String.valueOf(pow(a.doubleValue(),b.doubleValue()))));
                        symbol.push(y);
                        while(!number_s.empty()&&!symbol_s.empty()){
                            number.push(number_s.peek());
                            number_s.pop();
                            symbol.push(symbol_s.peek());
                            symbol_s.pop();
                        }
                        continue;
                    }
                    else if(x=='×'||x=='÷'){
                        if(y=='^'||y=='!'||y=='%'||y=='i'||y=='o'||y=='a'||y=='n'||y=='g'){
                            number_s.push(number.peek());
                            number.pop();
                            symbol_s.push(x);
                            symbol.push(y);
                            continue;
                        }
                        BigDecimal a=number.peek();number.pop();
                        BigDecimal b=number.peek();number.pop();
                        BigDecimal answer=new BigDecimal("0");
                        switch (x){
                            case '×':answer=a.multiply(b);break;
                            case '÷':
                                if(b.compareTo(new BigDecimal("0"))==0){
                                    textView.setText("错误");
                                    return;
                                }
                                answer=a.divide(b,17,BigDecimal.ROUND_HALF_UP);
                        }
                        symbol.push(y);
                        number.push(answer);
                        while(!number_s.empty()&&!symbol_s.empty()){
                            number.push(number_s.peek());
                            number_s.pop();
                            symbol.push(symbol_s.peek());
                            symbol_s.pop();
                        }
                        continue;
                    }
                    else if(x=='+'||x=='-'){
                        if(y=='×'||y=='÷'||y=='^'||y=='!'||y=='%'||y=='i'||y=='o'||y=='a'||y=='n'||y=='g'){
                            number_s.push(number.peek());
                            number.pop();
                            symbol_s.push(x);
                            symbol.push(y);
                            continue;
                        }
                        BigDecimal a=number.peek();number.pop();
                        BigDecimal b=number.peek();number.pop();
                        BigDecimal answer=new BigDecimal("0");
                        switch (x){
                            case '+':answer=a.add(b);break;
                            case '-':answer=a.subtract(b);break;
                        }
                        symbol.push(y);
                        number.push(answer);
                        while(!number_s.empty()&&!symbol_s.empty()){
                            number.push(number_s.peek());
                            number_s.pop();
                            symbol.push(symbol_s.peek());
                            symbol_s.pop();
                        }
                        continue;
                    }
                }
                if(number.size()!=1) {
                    textView.setText("错误");
                    return;
                }
                BigDecimal answer=number.peek().setScale(15,BigDecimal.ROUND_HALF_UP);
                if(answer.compareTo(new BigDecimal("0"))==0)
                    editText.setText("0");
                else if(answer.compareTo(new BigDecimal("1E+15"))<0)
                    editText.setText(answer.stripTrailingZeros().toPlainString());
                else editText.setText(answer.stripTrailingZeros().toString());
                editText.setSelection(editText.length());
                return;
                default:break;
        }


        textView.setText("");
        //除错
        if(content.length()>0) {
            flag = true;
            Stack<Integer> stack = new Stack<>();
            if (content.charAt(0) == '×' || content.charAt(0) == '÷' || content.charAt(0) == '^') {
                textView.setText("错误");
                return;
            }
            char s=content.charAt(content.length()-1);
            if(!(s==')'||(s>='0'&&s<='9')||s=='%'||s=='!'||s=='%'||s=='e'||s=='π')){
                textView.setText("错误");
                return;
            }
            int point = 0;
            StringBuffer stringBuffer=new StringBuffer();
            for(int i=0;i<content.length();i++){
                char x=content.charAt(i);
                if(x=='(')
                    stack.push(i);
                else if(x==')'){
                    if(stack.empty()){
                        textView.setText("错误");
                        return;
                    }
                    int j=stack.peek();
                    stack.pop();
                    if(j==i+1){
                        textView.setText("错误");
                        return;
                    }
                }
                if(i<content.length()-1){
                    char y=content.charAt(i+1);
                    if(x=='.'){
                        if(point==1){
                            textView.setText("错误");
                            return;
                        }
                        point=1;
                        if(!(y>='0'&&y<='9')){
                            textView.setText("错误");
                            return;
                        }
                        continue;
                    }
                    else if(x>='0'&&x<='9')
                        continue;
                    else if(x=='e'||x=='π'){
                        if(point==1){
                            textView.setText("错误");
                            return;
                        }
                        point=1;
                        continue;
                    }
                    else if(x=='('){
                        if (!(y == '-' || y == '+' || y == 'π' || (y >= '0' && y <= '9') || (y >= 'a' && y <= 'z')||y=='(')) {
                            textView.setText("错误");
                            return;
                        }
                    }
                    else if(x==')') {
                        if (!(y == '+' || y == '-' || y == '×' || y == '÷' || y == '!' || y == '%' || y == ')' || y == '^' )) {
                            textView.setText("错误");
                            return;
                        }
                    }
                    else if(x=='+'||x=='-'||x=='×'||x=='÷'){
                        if(!((y>='a'&&y<='z')||y=='π'||y=='e'||(y>='0'&&y<='9')||y=='(')){
                            textView.setText("错误");
                            return;
                        }
                    }
                    else if(x=='^'&&y!='('){
                        textView.setText("错误");
                        return;
                    }
                    else if(x=='!'||x=='%'){
                        if(!(y=='+'||y=='-'||y=='×'||y=='÷'||y=='!'||y=='%'||y==')')){
                            textView.setText("错误");
                            return;
                        }
                    }
                    point=0;
                }
            }
            if(!stack.empty()){
                textView.setText("错误");
                return;
            }
        }


    }
}
