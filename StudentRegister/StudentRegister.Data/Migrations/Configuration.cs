namespace StudentRegister.Data.Migrations
{
    using StudentRegister.Data.Entities;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<StudentRegister.Data.Context.StudentRegisterDBContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = true;
        }

        protected override void Seed(StudentRegister.Data.Context.StudentRegisterDBContext context)
        {
            context.Students.AddOrUpdate(x => x.StudentId,
         new Student() { StudentId = 1, FirstName = "luke", LastName = "Skywaker" },
         new Student() { StudentId = 2, FirstName = "Hank", LastName = "Pim" },
         new Student() { StudentId = 3, FirstName = "Jane", LastName = "Grouds" }
         );
            context.Nationalities.AddOrUpdate(x => x.NationalityId,
                new Nationality() { NationalityId = 1, Name = "Bulgaria" }
                );

            context.Faculties.AddOrUpdate(x => x.FacultyId,
                new Faculty() { FacultyId = 1, Name = "FMI", City = "Plovdiv" },
                new Faculty() { FacultyId = 2, Name = "Biology", City = "Plovdiv" }
                );


        }
    }
}
