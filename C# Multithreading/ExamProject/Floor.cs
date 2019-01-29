using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamProject
{
    class Floor
    {
       private static string[] allFloors = new string[] { "G", "S", "T1", "T2" };
       static Random rnda = new Random();



        public static string SetAgentFloor(string securityLevel)
        {
            if (securityLevel == "Confidential")
            {
                return allFloors[0];
            }
            else if (securityLevel == "Secret")
            {
                return allFloors[rnda.Next(1, 2)];
            }
            else if (securityLevel == "Top-Secret")
            {
                return allFloors[rnda.Next(1, 4)];
            }
            return null;
        }

    }
}
