using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Game
{
    abstract class Hero
    {
        Random rand = new Random();

        public double HealthPoints { get; set; }
        public double AttackPoints { get; set; }
        public double ArmorPoints { get; set; }
        public string Name { get; set; }

        public Hero(double health, double attack, double armor, string name)
        {
            this.Name = name;
            this.HealthPoints = health;
            this.AttackPoints = attack;
            this.ArmorPoints = armor;
        }
        public double ActualAttack()
        {
            double randNumber = rand.Next(80, 120);
            return randNumber / 100.0 * this.AttackPoints;
        }
        public double ActualArmor()
        {
            return rand.Next(80, 120) / 100 * this.ArmorPoints;
        }
        public virtual bool CanBlock()
        {
            return false;
        }
        public virtual void Attack(Hero defender)
        {

        }


    }
}
