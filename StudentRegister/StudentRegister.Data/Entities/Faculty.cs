using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentRegister.Data.Entities
{
   public class Faculty
    {
        public int FacultyId { get; set; }

        [Required]
        [MinLength(1), MaxLength(200)]
        public string Name { get; set; }

        [Required]
        public string City { get; set; }

        [MinLength(1), MaxLength(200)]
        public string Address { get; set; }

    }
}
