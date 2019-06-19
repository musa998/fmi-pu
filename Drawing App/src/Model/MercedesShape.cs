using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;

namespace Draw.src.Model
{

    [Serializable]

    public class MercedesShape :Shape
    {
        #region Constructor

        public MercedesShape(RectangleF rect) : base(rect)
        {
        }

        public MercedesShape(RectangleShape mercedes) : base(mercedes)
        {
        }

        #endregion

        /// <summary>
        /// Проверка за принадлежност на точка point към правоъгълника.
        /// В случая на правоъгълник този метод може да не бъде пренаписван, защото
        /// Реализацията съвпада с тази на абстрактния клас Shape, който проверява
        /// дали точката е в обхващащия правоъгълник на елемента (а той съвпада с
        /// елемента в този случай).
        /// </summary>
        public override bool Contains(PointF point)
        {
            if (base.Contains(point))
                // Проверка дали е в обекта само, ако точката е в обхващащия правоъгълник.
                // В случая на правоъгълник - директно връщаме true


                return true;
            else
                // Ако не е в обхващащия правоъгълник, то неможе да е в обекта и => false
                return false;
        }

        /// <summary>
        /// Частта, визуализираща конкретния примитив.
        /// </summary>
        public override void DrawSelf(Graphics grfx)
        {
            base.DrawSelf(grfx);
            base.RotateShape(grfx);

            grfx.FillRectangle(new SolidBrush(Color.FromArgb(Opacity, FillColor)), Rectangle.X, Rectangle.Y, Rectangle.Width, Rectangle.Height);
            grfx.DrawRectangle(new Pen(BorderColor, BorderWidth), Rectangle.X, Rectangle.Y, Rectangle.Width, Rectangle.Height);
            grfx.DrawLine(new Pen(BorderColor, BorderWidth), Rectangle.X, Rectangle.Y+Rectangle.Height, Rectangle.X + (Rectangle.Width / 2), Rectangle.Y + (Rectangle.Height / 2));
            grfx.DrawLine(new Pen(BorderColor, BorderWidth), Rectangle.X + Rectangle.Width, Rectangle.Y+Rectangle.Height, Rectangle.X + (Rectangle.Width / 2), Rectangle.Y + (Rectangle.Height / 2));
            grfx.DrawLine(new Pen(BorderColor, BorderWidth), Rectangle.X+(Rectangle.Width/2), Rectangle.Y, Rectangle.X + (Rectangle.Width / 2), Rectangle.Y + (Rectangle.Height / 2));
            grfx.ResetTransform();

        }
    }
}
