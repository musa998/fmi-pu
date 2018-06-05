using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Game
{
     class Knight : Hero
    {
        public Random rndd = new Random();

        public Knight(double health, double attack, double armor, string name)
            : base(health, attack, armor, name)
        {
        }

        public override bool CanBlock()
        {
            return rndd.Next(1, 101) <= 20;
        }
        /*
         * --- "to do 200% damage" - this condition was not very clear 
         * -- 200% can be the attacking points * 2(200%)
         * - or (attacking points - defender.ArrmorPoints) * 2   just like my code
         * So 
         * if(myCode == false)  cw("Don't blame me");
         * */

        public override void Attack(Hero defender)
        {
            double damage = ActualAttack() - defender.ActualArmor();
            bool canAttackW200 = rndd.Next(1, 101) <= 10;

            if (defender.CanBlock() == false && damage > 0)
            {
                if (canAttackW200)
                {
                    Console.WriteLine($"\n\t\t{Name} increase his points with 200%");
                    damage *= 2;
                }
                defender.HealthPoints -= damage;
                Console.WriteLine();
                Console.WriteLine($"\t\t{Name} attack {defender.Name} with {damage}");
                Console.WriteLine();
                Console.WriteLine($"{Name}- Attack Points - {AttackPoints} - Armor Points - " +
                    $"{ArmorPoints} - Health  {HealthPoints}");
                Console.WriteLine($"{defender.Name}- Attack Points - {defender.AttackPoints} - Armor Points - " +
                   $"{defender.ArmorPoints} - Health  {defender.HealthPoints}");
            }
            else
            {
                Console.WriteLine($"\n\t\t{Name} cannot attack");
            }
        }
    }
}
