namespace StudentRegister.Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Faculties",
                c => new
                    {
                        FacultyId = c.Int(nullable: false, identity: true),
                        Name = c.String(nullable: false, maxLength: 200),
                        City = c.String(nullable: false),
                        Address = c.String(maxLength: 200),
                    })
                .PrimaryKey(t => t.FacultyId);
            
            CreateTable(
                "dbo.Nationalities",
                c => new
                    {
                        NationalityId = c.Int(nullable: false, identity: true),
                        Name = c.String(nullable: false, maxLength: 100),
                    })
                .PrimaryKey(t => t.NationalityId);
            
            CreateTable(
                "dbo.Students",
                c => new
                    {
                        StudentId = c.Int(nullable: false, identity: true),
                        FirstName = c.String(nullable: false, maxLength: 100),
                        LastName = c.String(nullable: false, maxLength: 100),
                        DateOfBirth = c.DateTime(nullable: false),
                        NationalityId = c.Int(nullable: false),
                        FacultyId = c.Int(nullable: false),
                        Comment = c.String(),
                    })
                .PrimaryKey(t => t.StudentId)
                .ForeignKey("dbo.Faculties", t => t.FacultyId, cascadeDelete: true)
                .ForeignKey("dbo.Nationalities", t => t.NationalityId, cascadeDelete: true)
                .Index(t => t.NationalityId)
                .Index(t => t.FacultyId);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Students", "NationalityId", "dbo.Nationalities");
            DropForeignKey("dbo.Students", "FacultyId", "dbo.Faculties");
            DropIndex("dbo.Students", new[] { "FacultyId" });
            DropIndex("dbo.Students", new[] { "NationalityId" });
            DropTable("dbo.Students");
            DropTable("dbo.Nationalities");
            DropTable("dbo.Faculties");
        }
    }
}
