using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace NewWebApi2.Models
{
    public class StudentViewModel
    {
        public string FirstName { get; set; }

        public string LastName { get; set; }

        public string Comment { get; set; }

        public DateTime DateOfBirth { get; set; }
    }
}