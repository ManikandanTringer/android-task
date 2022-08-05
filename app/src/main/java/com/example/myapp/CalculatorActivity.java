    package com.example.myapp;

    import android.os.Bundle;
    import android.text.SpannableStringBuilder;
    import android.util.Log;
    import android.view.View;
    import android.widget.EditText;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;

    import java.util.Stack;

//    import org.mariuszgromada.math.mxparser.Expression;

    public class CalculatorActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        display=(EditText) findViewById(R.id.displayOperation);
        display.setShowSoftInputOnFocus(false);//no default keyboard pop up
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getString(R.string.defaultdisplay).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateDisplay(String addStr){
        String oldStr=display.getText().toString();
        int cursorPos=display.getSelectionStart();
        String leftStr=oldStr.substring(0,cursorPos);
        String rightStr=oldStr.substring(cursorPos);
        if(getString(R.string.defaultdisplay).equals(display.getText().toString())){
            display.setText(addStr);
            display.setSelection(cursorPos + 1);
        }
        else {
            display.setText(String.format("%s%s%s", leftStr, addStr, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }

        public void onePresssed(View view){
            updateDisplay("1");
        }
        public void twoPresssed(View view){
            updateDisplay("2");
        }
        public void threePresssed(View view){
            updateDisplay("3");
        }
        public void fourPresssed(View view){
            updateDisplay("4");
        }
        public void fivePresssed(View view){
            updateDisplay("5");
        }
        public void sixPresssed(View view){
            updateDisplay("6");
        }
        public void sevenPresssed(View view){
            updateDisplay("7");
        }
        public void eightPresssed(View view){
            updateDisplay("8");
        }
        public void ninePresssed(View view){
            updateDisplay("9");
        }
        public void zeroPresssed(View view){
            updateDisplay("0");
        }
        public void clearPresssed(View view){
        display.setText("");
        }
        public void exponentPresssed(View view){
            updateDisplay("^");
        }
        public void parenthesesPresssed(View view){

        int cursorPos=display.getSelectionStart();
        int openPar=0;
        int closedPar=0;
        int displayLength=display.getText().length();

        for(int i=0;i<cursorPos;i++){
            if(display.getText().toString().substring(i,i+1).equals("(")){
                openPar++;
            }
            if(display.getText().toString().substring(i,i+1).equals(")")){
                closedPar++;
            }
        }

            if(openPar == closedPar || display.getText().toString().substring(displayLength-1,displayLength).equals("(")){
                updateDisplay("(");
            }
            else if(closedPar < openPar && !display.getText().toString().substring(displayLength-1,displayLength).equals("(")){
                updateDisplay(")");
            }
            display.setSelection(cursorPos+1);


        }
        public void dividePresssed(View view){
            updateDisplay("/");
        }
        public void multiplyPresssed(View view){
            updateDisplay("*");
        }
        public void addPresssed(View view){
            updateDisplay("+");
        }
        public void subtractPresssed(View view){
            updateDisplay("-");
        }
        public void plusMinusPresssed(View view){
//            updateDisplay("");
        }
        public void pointPresssed(View view){
            updateDisplay(".");
        }

        public void backspacePresssed(View view){
        int cursorPos=display.getSelectionStart();
        int displayLength=display.getText().length();

        if(cursorPos != 0 && displayLength !=0 ){
            SpannableStringBuilder builder=(SpannableStringBuilder) display.getText();
            builder.replace(cursorPos-1,cursorPos,"");
            display.setText(builder);
            display.setSelection(cursorPos-1);
        }

        }

        public void equalsPresssed(View view){

            String userExpression=display.getText().toString();

            char[] tokens = userExpression.toCharArray();

            Stack<Double> values = new Stack<Double>();

            Stack<Character> ops = new Stack<Character>();

            for (int i = 0; i < tokens.length; i++)
            {


                if (tokens[i] == ' ')
                    continue;


                if (tokens[i] >= '0' &&
                        tokens[i] <= '9')
                {
                    StringBuffer sbuf = new
                            StringBuffer();


                    while (i < tokens.length &&
                            tokens[i] >= '0' &&
                            tokens[i] <= '9')
                        sbuf.append(tokens[i++]);
                    values.push(Double.parseDouble(sbuf.
                            toString()));


                    i--;
                }


                else if (tokens[i] == '(')
                    ops.push(tokens[i]);


                else if (tokens[i] == ')')
                {
                    while (ops.peek() != '(')
                        values.push(applyOp(ops.pop(),
                                values.pop(),
                                values.pop()));
                    ops.pop();
                }

                else if (tokens[i] == '+' ||
                        tokens[i] == '-' ||
                        tokens[i] == '*' ||
                        tokens[i] == '/')
                {

                    while (!ops.empty() &&
                            hasPrecedence(tokens[i],
                                    ops.peek()))
                        values.push(applyOp(ops.pop(),
                                values.pop(),
                                values.pop()));

                    ops.push(tokens[i]);
                }
            }

            while (!ops.empty())
                values.push(applyOp(ops.pop(),
                        values.pop(),
                        values.pop()));

            // Top of 'values' contains
            // result, return it
            String res=values.pop().toString();


                String newRes=checkDecimal(res);
                Log.d("cal",res);
                display.setText(newRes);
                display.setSelection(newRes.length());

//            return values.pop();
        }



//            Expression expression=new Expression(userExpression);
//            String result=String.valueOf(expression.calculate());
//            display.setText(result);
//            display.setSelection(result.length());



        public static boolean hasPrecedence(
                char op1, char op2)
        {
            if (op2 == '(' || op2 == ')')
                return false;
            if ((op1 == '*' || op1 == '/') &&
                    (op2 == '+' || op2 == '-'))
                return false;
            else
                return true;
        }



        public static double applyOp(char op,
                                     Double b, Double a)
        {

            switch (op)
            {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '/':
                    if (b == 0){
//                        setInfinty();
                        try{
                            double c=a/b;
                            
                        }catch (Exception e){
                            
                        }
                    }
                    return a / b;
//                default:
//                    throw new IllegalStateException("Unexpected value: " + op);
            }
            return 0;
        }

        private void setInfinty() {
        display.setText("Infinity");
            Toast.makeText(getBaseContext(), "Cannot divide by Zero", Toast.LENGTH_SHORT).show();

        }

        public String checkDecimal(String result){
        String a[]=result.split("\\.");
        if(a.length>1){
            if(a[1].equals("0")){
                result=a[0];
            }
        }
        return result;
}
}