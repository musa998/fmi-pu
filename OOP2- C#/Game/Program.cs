using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Game
{
    class Program
    {
        static void Main(string[] args)
        {
            Assasin assasin = new Assasin(600, 120, 22, "Killer");
            Knight knight = new Knight(600, 100, 35, "Lanselot");
            GameEngine game = new GameEngine();

            game.startGame(knight, assasin);


            Console.ReadLine();

        }
    }
}
