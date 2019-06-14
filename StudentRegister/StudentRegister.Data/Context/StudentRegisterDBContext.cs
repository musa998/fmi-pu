using StudentRegister.Data.Entities;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentRegister.Data.Context
{
   public class StudentRegisterDBContext : DbContext
    {
        public StudentRegisterDBContext() 
            : base("StudentRegisterDBContext")
        {

        }

        public DbSet<Student> Students { get; set; }

        public DbSet<Faculty> Faculties { get; set; }

        public DbSet<Nationality> Nationalities { get; set; }
    }
}
