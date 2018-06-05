using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Game
{
    class Assasin : Hero
    {
        Random rnd = new Random();
        public Assasin(double health, double attack, double armor, string name) : base(health, attack, armor, name)
        {
        }

        public override void Attack(Hero defender)
        {
            bool canAttackW300 = rnd.Next(1, 101) <= 30;
            double damage = ActualAttack() - defender.ActualArmor();
            if (damage > 0 && defender.CanBlock() == false)
            {
                if (canAttackW300)
                {
                    Console.WriteLine($"\n\t\t{Name} increase his points with 300%");
                    damage *= 3;
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
