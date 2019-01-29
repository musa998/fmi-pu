using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ExamProject
{
    class Program
    {
        static Random rnd = new Random();
        static string[] agentPermisions = new string[] { "Confidential", "Secret", "Top-Secret"};

        static int GetRandomValue()
        {
            lock (rnd) return rnd.Next(agentPermisions.Count());
        }
        static void Main()
        {

            Elevator elevator = new Elevator();
            List<Agent> agents = new List<Agent>();


            for (int i = 1; i < 2; i++)
            {
                agents.Add(new Agent(i, elevator, agentPermisions[GetRandomValue()]));
            }

            for (int i = 0; i < agents.Count; i++)
            {
                Console.WriteLine(agents[i].SecurityLevel);
            }

            Console.WriteLine("+++++++++++++++++");
            List<Thread> agentThreads = new List<Thread>();
            
            foreach (var a in agents)
            {
                Thread t = new Thread(() => a.Run());
                t.Start();
                agentThreads.Add(t);
            }

            foreach (var t in agentThreads)
            {
                t.Join();
            }
            Console.ReadLine();
        }
    }
}