using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ExamProject
{
    class Elevator
    {
       

        Floor floor;
        public int elevatorposition = 1;
        static object lockMove = new object();
        private Semaphore semaphore;
        public List<string> agentsSecLevel = new List<string>();
        public List<Agent> agentsInside = new List<Agent>();

        private string[] floors = new string[] { "G", "S", "T1", "T2" };


        public Elevator(int agents = 1)
        {
            this.floor = new Floor();
            semaphore = new Semaphore(agents, agents);
        }

        public string[] GetFloors()
        {
            return floors;
        }
        public void EnterElevator(Agent agent)
        {
            agentsInside.Add(agent);
            Console.WriteLine($"Agent {agent.number} enter elevator");
            //semaphore.WaitOne();
        }
        public void LeaveElevator(Agent agent)
        {
            lock (lockMove)
            {
                //agent.agentCurrentFloor = agent.floorAgentWant;
                this.agentsInside.Remove(agent);
               // semaphore.Release();
            }
        }

        public bool Goto(string destination)
        {

            if (elevatorposition != DestinationNumber(destination))
            {
                Console.WriteLine("Elevator going to floor " + destination);
            }
            int elWay = DestinationNumber(destination) - elevatorposition;
            switch (destination)
            {
                case "G":
                    elevatorposition = 1;
                    break;
                case "S":
                    elevatorposition = 2;
                    break;
                case "T1":
                    elevatorposition = 3;
                    break;
                case "T2":
                    elevatorposition = 4;
                    break;
            }
            for (int i = 0; i < Math.Abs(elWay); i++)
            {
                Thread.Sleep(1000);
            }
          
           
                var agentsForThisFloor = this.agentsInside
                  .Where(a => a.floorAgentWant == destination)
                  .ToList();
            if (CanOpenDoor(destination))
            {
                agentsForThisFloor
                    .ForEach(a => this.LeaveElevator(a));
                return true;
            }
            else
            {
                foreach (var agent in agentsForThisFloor)
                {
                    if (agent.HaveAcces(destination) == true)
                    {
                        agentsForThisFloor
                        .Where(a => a.HaveAcces(destination) == true)
                        .ToList()
                        .ForEach(a => a.ChooseFloor());
                    }
                }

                agentsForThisFloor
                        .Where(a => a.HaveAcces(destination) == false)
                        .ToList()
                        .ForEach(a => a.ChooseFloor());
                Console.WriteLine("Door can not open in " + destination);
                return false;
            }


           // Console.WriteLine("Elevator reached floor " + destination);
            //}
        }

        private void ShowMassage(string destination)
        {
            if (DestinationNumber(destination) == elevatorposition)
            {
                return;
            }
            else
            {
                Console.WriteLine("Elevator reached floor " + destination);
            }

        }
        public int DestinationNumber(string destination)
        {
            int result = 0;
            switch (destination)
            {
                case "G":
                    result = 1;
                    break;
                case "S":
                    result = 2;
                    break;
                case "T1":
                    result = 3;
                    break;
                case "T2":
                    result = 4;
                    break;
            }
            return result;
        }

        public bool CanOpenDoor(string destination)
        {
            if (destination == "G")
            {
                return true;
            }
            else if (destination == "S")
            {
                foreach (var a in agentsSecLevel)
                {
                    if (a == "Confidential")
                    {
                        return false;
                    }
                }
                return true;
            }
            else if (destination == "T1")
            {
                foreach (var a in agentsSecLevel)
                {
                    if (a == "Confidential" || a == "Secret")
                    {
                        return false;
                    }
                }
                return true;
            }
            else if (destination == "T2")
            {
                foreach (var a in agentsSecLevel)
                {
                    if (a == "Confidential" || a == "Secret")
                    {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }
}
