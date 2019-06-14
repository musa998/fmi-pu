using System;
using System.Data.Entity;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentRegister.Data.Entities
{
   public class Student
    {
        public int StudentId { get; set; }

        [Required]
        [MinLength(1), MaxLength(100)]
        public string FirstName { get; set; }

        [Required]
        [MinLength(1), MaxLength(100)]
        public string LastName { get; set; }

        public DateTime DateOfBirth { get; set; }

        public int NationalityId { get; set; }
        public virtual Nationality Nationality { get; set; }

        public int FacultyId { get; set; }
        public virtual Faculty Faculty { get; set; }

        public string Comment { get; set; }

    }
}
