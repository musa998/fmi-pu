using StudentRegister.Data.Context;
using StudentRegister.Data.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentRegister.Data.Repository
{
    public class UnitOfWork : IDisposable
    {
        private StudentRegisterDBContext context = new StudentRegisterDBContext();
        private GenericRepository<Student> studentRepository;
        private GenericRepository<Faculty> facultyReposiotry;
        private GenericRepository<Nationality> nationalityRepository;


        public GenericRepository<Student> StudentRepository
        {
            get
            {

                if (this.studentRepository == null)
                {
                    this.studentRepository = new GenericRepository<Student>(context);
                }
                return studentRepository;
            }
        }

        public GenericRepository<Faculty> FacultyReposiotry
        {
            get
            {
                if (this.facultyReposiotry == null)
                {
                    this.facultyReposiotry = new GenericRepository<Faculty>(context);
                }
                return facultyReposiotry;
            }
        }


        public GenericRepository<Nationality> NationalityRepository
        {
            get
            {

                if (this.nationalityRepository == null)
                {
                    this.nationalityRepository = new GenericRepository<Nationality>(context);
                }
                return nationalityRepository;
            }
        }

        public void Save()
        {
            context.SaveChanges();
        }

        private bool disposed = false;

        protected virtual void Dispose(bool disposing)
        {
            if (!this.disposed)
            {
                if (disposing)
                {
                    context.Dispose();
                }
            }
            this.disposed = true;
        }

        public void Dispose()
        {
            Dispose(true);
            GC.SuppressFinalize(this);
        }
    }
}
