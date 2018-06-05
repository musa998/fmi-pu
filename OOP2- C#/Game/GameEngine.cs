using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Game
{
    class GameEngine
    {
      
        public void startGame(Hero hero, Hero oponent)
        {
            int count = 1;
            while (hero.HealthPoints > 0 && oponent.HealthPoints > 0)
            {
                Console.WriteLine("Raw " + count++);
                hero.Attack(oponent);

                if (oponent.HealthPoints < 0 || hero.HealthPoints < 0)
                    break;

                oponent.Attack(hero);
                Console.WriteLine("-----------------------------------------------");
            }
            if (hero.HealthPoints <= 0)
            {
                Console.WriteLine("Winner "+ oponent.Name);
            }
            else
            {
                Console.WriteLine("Winner " + hero.Name);
            }


        }
    }
}
