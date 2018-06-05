using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Game
{
    class Warrior : Hero
    {
        public Warrior(double health, double attack, double armor, string name) : base(health, attack, armor, name)
        {
        }

        public override void Attack(Hero defender)
        {
            double damage = ActualAttack() - defender.ActualArmor();

            Console.WriteLine($"\t\t{Name} attack {defender.Name} with {damage}");
            Console.WriteLine();
            Console.WriteLine($"{Name}- Attack Points - {AttackPoints} - Armor Points - " +
                $"{ArmorPoints} - Health  {HealthPoints}");
            Console.WriteLine($"{defender.Name}- Attack Points - {defender.AttackPoints} - Armor Points - " +
               $"{defender.ArmorPoints} - Health  {defender.HealthPoints}");
        }
    }
}
