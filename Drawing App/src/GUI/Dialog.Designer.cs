namespace Draw.src.GUI
{
    partial class Dialog
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.allValue_label = new System.Windows.Forms.Label();
            this.hight_label = new System.Windows.Forms.Label();
            this.allValue_textBox = new System.Windows.Forms.TextBox();
            this.hight_textBox = new System.Windows.Forms.TextBox();
            this.okButton = new System.Windows.Forms.Button();
            this.cancelButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // allValue_label
            // 
            this.allValue_label.AutoSize = true;
            this.allValue_label.Location = new System.Drawing.Point(8, 15);
            this.allValue_label.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.allValue_label.Name = "allValue_label";
            this.allValue_label.Size = new System.Drawing.Size(99, 17);
            this.allValue_label.TabIndex = 0;
            this.allValue_label.Text = "Border Width :";
            this.allValue_label.TextAlign = System.Drawing.ContentAlignment.TopRight;
            // 
            // hight_label
            // 
            this.hight_label.AutoSize = true;
            this.hight_label.Location = new System.Drawing.Point(219, 15);
            this.hight_label.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.hight_label.Name = "hight_label";
            this.hight_label.Size = new System.Drawing.Size(49, 17);
            this.hight_label.TabIndex = 1;
            this.hight_label.Text = "Hight :";
            // 
            // allValue_textBox
            // 
            this.allValue_textBox.Location = new System.Drawing.Point(109, 11);
            this.allValue_textBox.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.allValue_textBox.Name = "allValue_textBox";
            this.allValue_textBox.Size = new System.Drawing.Size(96, 22);
            this.allValue_textBox.TabIndex = 2;
            // 
            // hight_textBox
            // 
            this.hight_textBox.Location = new System.Drawing.Point(272, 11);
            this.hight_textBox.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.hight_textBox.Name = "hight_textBox";
            this.hight_textBox.Size = new System.Drawing.Size(96, 22);
            this.hight_textBox.TabIndex = 3;
            // 
            // okButton
            // 
            this.okButton.ForeColor = System.Drawing.Color.Green;
            this.okButton.Location = new System.Drawing.Point(108, 43);
            this.okButton.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.okButton.Name = "okButton";
            this.okButton.Size = new System.Drawing.Size(100, 28);
            this.okButton.TabIndex = 4;
            this.okButton.Text = "OK";
            this.okButton.UseVisualStyleBackColor = true;
            this.okButton.Click += new System.EventHandler(this.okButton_Click);
            // 
            // cancelButton
            // 
            this.cancelButton.ForeColor = System.Drawing.Color.Maroon;
            this.cancelButton.Location = new System.Drawing.Point(271, 43);
            this.cancelButton.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.cancelButton.Name = "cancelButton";
            this.cancelButton.Size = new System.Drawing.Size(100, 28);
            this.cancelButton.TabIndex = 5;
            this.cancelButton.Text = "CANCEL";
            this.cancelButton.UseVisualStyleBackColor = true;
            this.cancelButton.Click += new System.EventHandler(this.cancelButton_Click);
            // 
            // Dialog
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(493, 84);
            this.Controls.Add(this.cancelButton);
            this.Controls.Add(this.okButton);
            this.Controls.Add(this.hight_textBox);
            this.Controls.Add(this.allValue_textBox);
            this.Controls.Add(this.hight_label);
            this.Controls.Add(this.allValue_label);
            this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Name = "Dialog";
            this.Text = "Dialog";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label allValue_label;
        private System.Windows.Forms.Label hight_label;
        private System.Windows.Forms.TextBox allValue_textBox;
        private System.Windows.Forms.TextBox hight_textBox;
        private System.Windows.Forms.Button okButton;
        private System.Windows.Forms.Button cancelButton;
    }
}