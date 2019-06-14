//using StudentRegister.Data.Entities;
//using System;
//using System.Collections.Generic;
//using System.Data.Entity;
//using System.Data.Entity.Infrastructure;
//using System.Linq;
//using System.Text;
//using System.Threading.Tasks;

//namespace StudentRegister.Data.Context
//{
//    public interface IApplicationDbContext
//    {
//        IDbSet<Student> Students { get; set; }
//        IDbSet<Faculty> Faculties { get; set; }
//        IDbSet<Nationality> Nationalityes { get; set; }
//        IDbSet<T> Set<T>() where T : class;
//        DbEntityEntry<T> Entry<T>(T entity) where T : class;
//        int SaveChanges();
//    }
//}
