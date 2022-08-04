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

            // Stack for numbers: 'values'
            Stack<Double> values = new Stack<Double>();

            // Stack for Operators: 'ops'
            Stack<Character> ops = new Stack<Character>();

            for (int i = 0; i < tokens.length; i++)
            {

                // Current token is a
                // whitespace, skip it
                if (tokens[i] == ' ')
                    continue;

                // Current token is a number,
                // push it to stack for numbers
                if (tokens[i] >= '0' &&
                        tokens[i] <= '9')
                {
                    StringBuffer sbuf = new
                            StringBuffer();

                    // There may be more than one
                    // digits in number
                    while (i < tokens.length &&
                            tokens[i] >= '0' &&
                            tokens[i] <= '9')
                        sbuf.append(tokens[i++]);
                    values.push(Double.parseDouble(sbuf.
                            toString()));

                    // right now the i points to
                    // the character next to the digit,
                    // since the for loop also increases
                    // the i, we would skip one
                    //  token position; we need to
                    // decrease the value of i by 1 to
                    // correct the offset.
                    i--;
                }

                // Current token is an opening brace,
                // push it to 'ops'
                else if (tokens[i] == '(')
                    ops.push(tokens[i]);

                    // Closing brace encountered,
                    // solve entire brace
                else if (tokens[i] == ')')
                {
                    while (ops.peek() != '(')
                        values.push(applyOp(ops.pop(),
                                values.pop(),
                                values.pop()));
                    ops.pop();
                }

                // Current token is an operator.
                else if (tokens[i] == '+' ||
                        tokens[i] == '-' ||
                        tokens[i] == '*' ||
                        tokens[i] == '/')
                {
                    // While top of 'ops' has same
                    // or greater precedence to current
                    // token, which is an operator.
                    // Apply operator on top of 'ops'
                    // to top two elements in values stack
                    while (!ops.empty() &&
                            hasPrecedence(tokens[i],
                                    ops.peek()))
                        values.push(applyOp(ops.pop(),
                                values.pop(),
                                values.pop()));

                    // Push current token to 'ops'.
                    ops.push(tokens[i]);
                }
            }

            // Entire expression has been
            // parsed at this point, apply remaining
            // ops to remaining values
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



        // Returns true if 'op2' has higher
        // or same precedence as 'op1',
        // otherwise returns false.
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


        // A utility method to apply an
        // operator 'op' on operands 'a'
        // and 'b'. Return the result.
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