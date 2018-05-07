using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Calculator
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        double num;
        int count;
        double op;
        double num2;
        double percentage = 0.01;
        double fOperand;
        double memoryStore;
        bool checkForEndResult= false;

       

        private void button15_Click(object sender, EventArgs e)
        {

        }

        private void button6_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged_1(object sender, EventArgs e)
        {

        }

        private void button6_Click_1(object sender, EventArgs e)
        {
           
            if (checkForEndResult)
            {
                textBox1.Clear();
            }
            checkForEndResult = false;
            if (textBox1.Text == "0" && textBox1.Text != null)
            {
                textBox2.Text += "7";
                textBox1.Text = "7";
                textBox1.ForeColor = Color.White;
            }
            else
            {
                textBox2.Text = textBox2.Text + "7";
                textBox1.Text = textBox1.Text + "7";
                textBox1.ForeColor = Color.White;
            }
            
        }
        private void button15_Click_1(object sender, EventArgs e)
        {

            if (checkForEndResult)
            {
                textBox1.Clear();
            }
            checkForEndResult = false;
            if (textBox1.Text == "0" && textBox1.Text != null)
            {
                textBox1.Text = "8";
                textBox2.Text = "8";
                textBox1.ForeColor = Color.White;
            }
            else
            {
                textBox1.Text = textBox1.Text + "8";
                textBox2.Text = textBox2.Text + "8";
                textBox1.ForeColor = Color.White;
            }
        }

        private void button12_Click(object sender, EventArgs e)
        {
            

            if (checkForEndResult)
            {
                textBox1.Clear();
            }
            checkForEndResult = false;
            if (textBox1.Text == "0" && textBox1.Text != null)
            {
                textBox2.Text += "9";
                textBox1.Text = "9";
                textBox1.ForeColor = Color.White;
            }
            else
            {
                textBox1.Text = textBox1.Text + "9";
                textBox2.Text = textBox2.Text + "9";
                textBox1.ForeColor = Color.White;
            }
        }

        private void button19_Click(object sender, EventArgs e)
        {
            if (checkForEndResult)
            {
                textBox1.Clear();
            }
            checkForEndResult = false;
            if (textBox1.Text == "0" && textBox1.Text != null)
            {
                textBox2.Text = "4";
                textBox1.Text = "4";
                textBox1.ForeColor = Color.White;
            }
            else
            {
                textBox1.Text = textBox1.Text + "4";
                textBox2.Text = textBox2.Text + "4";
                textBox1.ForeColor = Color.White;
            }
        }

        private void button16_Click(object sender, EventArgs e)
        {
            if (checkForEndResult)
            {
                textBox1.Clear();
            }
            checkForEndResult = false;
            if (textBox1.Text == "0" && textBox1.Text != null)
            {
                textBox1.Text = "5";
                textBox2.Text = "5";
                textBox1.ForeColor = Color.White;
            }
            else
            {
                textBox1.Text = textBox1.Text + "5";
                textBox2.Text = textBox2.Text + "5";
                textBox1.ForeColor = Color.White;
            }
        }

        private void button7_Click(object sender, EventArgs e)
        {
            if (checkForEndResult)
            {
                textBox1.Clear();
            }
            checkForEndResult = false;
            if (textBox1.Text == "0" && textBox1.Text != null)
            {
                textBox1.Text = "6";
                textBox2.Text = "6";
                textBox1.ForeColor = Color.White;
            }
            else
            {
                textBox1.Text = textBox1.Text + "6";
                textBox2.Text = textBox2.Text + "6";
                textBox1.ForeColor = Color.White;
            }
        }

        private void button18_Click(object sender, EventArgs e)
        {
            if (checkForEndResult)
            {
                textBox1.Clear();
            }
            checkForEndResult = false;
            if (textBox1.Text == "0" && textBox1.Text != null)
            {
                textBox1.Text = "1";
                textBox2.Text = "1";
                textBox1.ForeColor = Color.White;
            }
            else
            {
                textBox1.Text = textBox1.Text + "1";
                textBox2.Text = textBox2.Text + "1";
                textBox1.ForeColor = Color.White;
            }
        }

        private void button17_Click(object sender, EventArgs e)
        {
            if (checkForEndResult)
            {
                textBox1.Clear();
            }
            checkForEndResult = false;
            if (textBox1.Text == "0" && textBox1.Text != null)
            {
                textBox1.Text = "2";
                textBox2.Text = "2";
                textBox1.ForeColor = Color.White;
            }
            else
            {
                textBox1.Text = textBox1.Text + "2";
                textBox2.Text = textBox2.Text + "2";
                textBox1.ForeColor = Color.White;
            }
        }

        private void button10_Click(object sender, EventArgs e)
        {
            if (checkForEndResult)
            {
                textBox1.Clear();
            }
            checkForEndResult = false;
            if (textBox1.Text == "0" && textBox1.Text != null)
            {
                textBox1.Text = "3";
                textBox2.Text = "3";
                textBox1.ForeColor = Color.White;
            }
            else
            {
                textBox1.Text = textBox1.Text + "3";
                textBox2.Text = textBox2.Text + "3";
                textBox1.ForeColor = Color.White;
            }
        }

        private void button11_Click(object sender, EventArgs e)
        {
            if (checkForEndResult)
            {
                textBox1.Clear();
            }
            checkForEndResult = false;
            if (textBox1.Text == "0" && textBox1.Text != null)
            {
                textBox1.Text = "0";
                textBox2.Text = "0";
                textBox1.ForeColor = Color.White;
               
            }
            else
            {
                textBox1.Text = textBox1.Text + "0";
                textBox2.Text = textBox2.Text + "0";
                textBox1.ForeColor = Color.White;
               
            }
        }
        private void button9_Click(object sender, EventArgs e)
        {
            num = double.Parse(textBox1.Text);
            fOperand = num;
            textBox1.Clear();
            count = 1;

            textBox2.Text += " + ";
          
            if (label2.Text != "         ")
            {
                 fOperand = double.Parse(label2.Text.Substring(0, label2.Text.Length - 1));
                char operation = label2.Text[label2.Text.Length - 1];
                switch (operation)
                {
                    case '+':
                        fOperand += num;
                        label2.Text = fOperand.ToString() + "+";
                        break;
                    case '-':
                        fOperand -= num;
                        label2.Text = fOperand.ToString() + "+";
                        break;
                    case 'x':
                        fOperand *= num;
                        label2.Text = fOperand.ToString() + "+";
                        break;
                    case '÷':
                        fOperand /= num;
                        label2.Text = fOperand.ToString() + "+";
                        break;
                    case '%':
                        fOperand %= num;
                        label2.Text = fOperand.ToString() + "+";
                        break;
                }
            }
            else
            {
                label2.Text = num.ToString() + "+";
            }
        }
        private void button8_Click(object sender, EventArgs e)
        {

            num = double.Parse(textBox1.Text);
            fOperand = num;
            textBox1.Clear();
            count = 2;
            textBox2.Text += " - ";
            if (label2.Text != "         ")
            {
                fOperand = double.Parse(label2.Text.Substring(0, label2.Text.Length - 1));
                char operation = label2.Text[label2.Text.Length - 1];
                switch (operation)
                {
                    case '+':
                        fOperand += num;
                        label2.Text = fOperand.ToString() + "-";
                        break;
                    case '-':
                        fOperand -= num;
                        label2.Text = fOperand.ToString() + "-";
                        break;
                    case 'x':
                        fOperand *= num;
                        label2.Text = fOperand.ToString() + "-";
                        break;
                    case '÷':
                        fOperand /= num;
                        label2.Text = fOperand.ToString() + "-";
                        break;
                    case '%':
                        fOperand %= num;
                        label2.Text = fOperand.ToString() + "-";
                        break;
                }
            }
            else
            {
                label2.Text = num.ToString() + "-";
            }
        }
        private void button2_Click(object sender, EventArgs e)
        {
            decimal number;
            bool isNum = decimal.TryParse(textBox1.Text,out number);

            textBox2.Text += " x ";
            if (isNum)
            {
                num = double.Parse(textBox1.Text);
                fOperand = num;
                textBox1.Clear();
                count = 3;
                if (label2.Text != "         ")
                {
                    fOperand = double.Parse(label2.Text.Substring(0, label2.Text.Length - 1));
                    char operation = label2.Text[label2.Text.Length - 1];
                    switch (operation)
                    {
                        case '+':
                            fOperand += num;
                            label2.Text = fOperand.ToString() + "x";
                            break;
                        case '-':
                            fOperand -= num;
                            label2.Text = fOperand.ToString() + "x";
                            break;
                        case 'x':
                            fOperand *= num;
                            label2.Text = fOperand.ToString() + "x";
                            break;
                        case '÷':
                            fOperand /= num;
                            label2.Text = fOperand.ToString() + "x";
                            break;
                        case '%':
                            fOperand %= num;
                            label2.Text = fOperand.ToString() + "x";
                            break;
                    }
                }
                else
                {
                    label2.Text = num.ToString() + "x";
                }
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            num = double.Parse(textBox1.Text);
            textBox1.Clear();
            count = 4;
            textBox2.Text += " ÷ ";
            if (label2.Text != "         ")
            {
               fOperand = double.Parse(label2.Text.Substring(0, label2.Text.Length - 1));
                char operation = label2.Text[label2.Text.Length - 1];
                switch (operation)
                {
                    case '+':
                        fOperand += num;
                        label2.Text = fOperand.ToString() + "÷";
                        break;
                    case '-':
                        fOperand -= num;
                        label2.Text = fOperand.ToString() + "÷";
                        break;
                    case 'x':
                        fOperand *= num;
                        label2.Text = fOperand.ToString() + "÷";
                        break;
                    case '÷':
                        fOperand /= num;
                        label2.Text = fOperand.ToString() + "÷";
                        break;
                    case '%':
                        fOperand %= num;
                        label2.Text = fOperand.ToString() + "x";
                        break;
                }
            }
            else
            {
                label2.Text = num.ToString() + "÷";
            }
        }

        private void button21_Click(object sender, EventArgs e)
        {
            num = double.Parse(textBox1.Text);
            fOperand = num;
            textBox1.Clear();
            count = 5;
            textBox2.Text += " % ";
            if (label2.Text != "         ")
            {
                 fOperand = double.Parse(label2.Text.Substring(0, label2.Text.Length - 1));
                char operation = label2.Text[label2.Text.Length - 1];
                switch (operation)
                {
                    case '+':
                        fOperand += num;
                        label2.Text = fOperand.ToString() + "%";
                        break;
                    case '-':
                        fOperand -= num;
                        label2.Text = fOperand.ToString() + "%";
                        break;
                    case 'x':
                        fOperand *= num;
                        label2.Text = fOperand.ToString() + "%";
                        break;
                    case '÷':
                        fOperand /= num;
                        label2.Text = fOperand.ToString() + "%";
                        break;
                    case '%':
                        fOperand %= num;
                        label2.Text = fOperand.ToString() + "%";
                        break;
                }
            }
            else
            {
                label2.Text = num.ToString() + "%";
            }
        }

        
        public void calculate()
        {
            switch (count)
            {
                case 1:

                    if (textBox1.Text.Contains(op.ToString()))
                    {
                        op = op + num2;
                        textBox1.Text = op.ToString();
                    }
                    else
                    {
                        if (textBox1.Text == " ") num2 = fOperand;
                        else
                        {
                            num2 = double.Parse(textBox1.Text);
                        }
                        op = fOperand + num2;
                        fOperand += num2;
                        textBox1.Text = op.ToString();
                    }
                    break;
                case 2:
                    if (textBox1.Text.Contains(op.ToString()))
                    {
                        op = op - num2;
                        textBox1.Text = op.ToString();
                    }
                    else
                    {
                        num2 = double.Parse(textBox1.Text);
                        op = fOperand - num2;
                        fOperand = op;
                        textBox1.Text = op.ToString();
                    }
                    break;
                case 3:
                    op = fOperand * double.Parse(textBox1.Text);
                    fOperand = op;
                    textBox1.Text = op.ToString();
                    break;
                case 4:
                    if (textBox1.Text.Contains(op.ToString()))
                    {
                        op = op / num2;
                        fOperand = op;
                        if (num2 == 0) textBox1.Text = "Cannot devide by zero!";

                        else
                            textBox1.Text = op.ToString();
                    }
                    else
                    {
                        num2 = double.Parse(textBox1.Text);
                        op = fOperand / num2;
                        fOperand = op;
                        if (num2 == 0) textBox1.Text = "Cannot divide by zero!";
                        else
                            textBox1.Text = op.ToString();
                    }
                    break;
                case 5:
                    op = fOperand * percentage * double.Parse(textBox1.Text);
                    fOperand = op;
                    textBox1.Text = op.ToString();
                    break;
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            calculate();
            label2.Text = "         ";
            checkForEndResult = true;
        }
        private void button4_Click(object sender, EventArgs e)
        {
            if (!textBox1.Text.Contains('.'))
            {
                textBox1.Text += '.';
            }
            textBox1.ForeColor = Color.White;
        }

        private void button20_Click(object sender, EventArgs e)
        {
            int lenght = textBox1.TextLength - 1;
            string text = textBox1.Text;
            textBox1.Clear();
            for (int i = 0; i < lenght; i++)
                textBox1.Text = textBox1.Text + text[i];
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void button28_Click(object sender, EventArgs e)
        {
            checkForEndResult = true;
            if (textBox1.Text == "0" || textBox1.Text != null)
            {
                memoryStore = double.Parse(textBox1.Text);
            }
           
        }

        private void button29_Click(object sender, EventArgs e)
        {
            memoryStore += double.Parse(textBox1.Text);
        }
        private void button30_Click(object sender, EventArgs e)
        {
            memoryStore -= double.Parse(textBox1.Text);
        }

        private void button31_Click(object sender, EventArgs e)
        {
            memoryStore = 0;
            textBox1.Text = "0";
        }

        private void button32_Click(object sender, EventArgs e)
        {
            textBox1.Text = memoryStore.ToString();
            textBox1.ForeColor = Color.White;
        }

        private void button25_Click(object sender, EventArgs e)
        {
            textBox2.Text = " ";
            textBox1.Text = " ";
            label2.Text = "         ";
            op = ' ';
        }
    }
}
