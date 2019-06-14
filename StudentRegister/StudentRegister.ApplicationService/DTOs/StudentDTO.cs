using StudentRegister.Data.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentRegister.ApplicationService.DTOs
{
   public class StudentDTO
    {
        public int Id { get; set; }

        public string FirstName { get; set; }

        public string LastName { get; set; }

        public DateTime DateOfBirth { get; set; }

        public string Comment { get; set; }

        public int FacultyId{ get; set; }

        public int NationalityId { get; set; }

        public bool Validate()
        {
            return !String.IsNullOrEmpty(FirstName) && !String.IsNullOrEmpty(LastName)
                && FacultyId != 0 &&
                NationalityId != 0;
        }
    }
}
