using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ExamProject
{
    class Agent
    {
        public static Random rand = new Random();
        private bool agentIsonWork = true;
        public string floorAgentWant;
        private ManualResetEvent insideElevator = new ManualResetEvent(false);

        private static readonly Object obj = new Object();

        public string SecurityLevel { get; set; }

        public string agentCurrentFloor = "G";    ///Floor.SetAgentFloor(SecurityLevel);

        public int number { get; set; }

        public Elevator Elevator { get; set; }

        public Agent(int number, Elevator elevator, string secLevel)
        {
            Elevator = elevator;
            SecurityLevel = secLevel;       
            ChooseFloor();

            Elevator.agentsSecLevel.Add(SecurityLevel);
            this.number = number;
        }
        public bool HaveAcces(string d)
        {
            lock (obj)
            {
                if (d == "G")
                {
                    return true;
                }
                else if (d == "S")
                {
                    if (SecurityLevel == "Confidential")
                    {
                        return false;
                    }
                }
                else if (d == "T1")
                {
                    if (SecurityLevel == "Confidential" || SecurityLevel == "Secret")
                    {
                        return false;
                    }
                }
                else if (d == "T2")
                {
                    if (SecurityLevel != "Top-Secret")
                    {
                        return false;
                    }
                }
                return true;
            }
        }


        private int GetRandomValue(int boundary)
        {
            lock (rand) return rand.Next(boundary);
        }
        public void ChooseFloor()
        {
            int numberFloors = 4;

            //if (SecurityLevel == "Confidential")
            //{
            //    numberFloors = 1;
            //}
            //else if (SecurityLevel == "Secret")
            //{
            //    numberFloors = 2;
            //}
            //else if (SecurityLevel == "Top-Secret")
            //{
            //    numberFloors = 4;
            //}
            var options = Elevator.GetFloors();
            int optionIndex = GetRandomValue(numberFloors);
            floorAgentWant = options[optionIndex];
            insideElevator.Set();
        }
        public bool CallEvevator()
        {
                return Elevator.Goto(agentCurrentFloor);
        }

        public void Run()
        {
            while (agentIsonWork)
            {
                switch (rand.Next(3))
                {
                    case 1:
                        Console.WriteLine($"Agent {number} ------ {SecurityLevel} is waiting elevator at {agentCurrentFloor}");
                        if (CallEvevator())
                        {
                            Elevator.EnterElevator(this);
                        }
                        ChooseFloor();
                        insideElevator.WaitOne(0);
                        lock (obj)
                        {
                            while (Elevator.Goto(floorAgentWant) == false) { }
                            Console.WriteLine($"Agent {number} exit on floor {floorAgentWant}");
                            Thread.Sleep(3000);
                            agentCurrentFloor = floorAgentWant;
                            //agentCurrentFloor = floorAgentWant;
                        }

                        break;
                    case 2:
                        Elevator.LeaveElevator(this);
                        //agentCurrentFloor = floorAgentWant;
                        if (agentCurrentFloor == "G")
                        {
                            Console.WriteLine($"Agent {number} ---- {SecurityLevel} has finished for today {agentCurrentFloor}");
                            agentIsonWork = false;
                            break;
                        }
                        CallEvevator();
                        Elevator.EnterElevator(this);
                        while (Elevator.Goto("G") == false) { }
                        Console.WriteLine($"Agent {number} ---- {SecurityLevel} has finished for today {agentCurrentFloor}");
                        agentIsonWork = false;
                        break;
                }
            }







            /*
            floor.Level = ChooseFloor();
            Thread.Sleep(500);
            Elevator.EnterElevator();
            floorAgentWant = ChooseFloor();
            while (agentIsInside)
            {
                //Thread.Sleep(500); 
                lock (obj)
                {

                    if (floor.DoorOpens(SecurityLevel,floor.Level))
                    {
                        Elevator.Goto(floor.Level);
                        Console.WriteLine($"----------------Door opens--------------- {Elevator.currPosition}  \n\n" + 
                            $"Agent number {number}({SecurityLevel}) " +
                            $"exit the elevator at floor ");   //{ floor.SetFloorSecLevel(Elevator.currPosition)}
                        agentIsInside = false;
                        Elevator.LeaveElevator();
                    }
                    else
                    {
                        Console.WriteLine("Door can not open.");
                        floor.Level = ChooseFloor();
                    }
                }
            }
            */


        }
    }
}
