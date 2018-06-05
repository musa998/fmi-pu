using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Game
{
    class Avenger : Hero
    {
        Random rrnd = new Random();
        public Avenger(double health, double attack, double armor, string name) : base(health, attack, armor, name)
        {
        }

        public override void Attack(Hero defender)
        {
            double damage = ActualAttack() - defender.ActualArmor();
            bool canAttackW500 = rrnd.Next(1, 101) <= 40;

            if (defender.CanBlock() == false && damage > 0)
            {
                if (canAttackW500)
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

        public override bool CanBlock()
        {
            return  rrnd.Next(1, 101) <= 35;
        }
    }
}
