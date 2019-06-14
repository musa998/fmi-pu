using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentRegister.Data.Entities
{
   public class Nationality
    {
        public int NationalityId { get; set; }

        [Required]
        [MinLength(1), MaxLength(100)]
        public string Name { get; set; }

    }
}
