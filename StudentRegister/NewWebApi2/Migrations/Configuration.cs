namespace NewWebApi2.Migrations
{
    using StudentRegister.Data.Context;
    using StudentRegister.Data.Entities;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<StudentRegisterDBContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = true;
        }

        protected override void Seed(StudentRegisterDBContext context)
        {
           
        }
    }
}
