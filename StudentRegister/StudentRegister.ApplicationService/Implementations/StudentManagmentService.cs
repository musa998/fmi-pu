using StudentRegister.ApplicationService.DTOs;
using StudentRegister.Data.Entities;
using StudentRegister.Data.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentRegister.ApplicationService.Implementations
{
   public class StudentManagmentService
    {
        public List<StudentDTO> Get()
        {
            List<StudentDTO> studentDTO = new List<StudentDTO>();

            using (UnitOfWork unitOfWork = new UnitOfWork())
            {
                foreach (var item in unitOfWork.StudentRepository.Get())
                {
                    studentDTO.Add(new StudentDTO
                    {
                        Id = item.StudentId,
                        FirstName = item.FirstName,
                        LastName = item.LastName,
                        Comment = item.Comment,
                        FacultyId = item.FacultyId,
                        NationalityId = item.NationalityId

                    });
                }
            }

            return studentDTO;
        }

        public StudentDTO GetById(int id)
        {
            StudentDTO studentDTO = new StudentDTO();

            using (UnitOfWork unitOfWork = new UnitOfWork())
            {
                Student student = unitOfWork.StudentRepository.GetByID(id);
                studentDTO = new StudentDTO
                {
                    Id = id,
                    FirstName = student.FirstName,
                    LastName = student.LastName,
                    Comment = student.Comment,
                    FacultyId = student.FacultyId,
                    NationalityId = student.NationalityId
                };
            }

            return studentDTO;
        }

        public bool Update(StudentDTO studentDTO)
        {
            if (studentDTO.Id == 0) return false;

            try
            {
                using (UnitOfWork unitOfWork = new UnitOfWork())
                {
                    Student student = new Student
                    {
                        StudentId = studentDTO.Id,
                        FirstName = studentDTO.FirstName,
                        LastName = studentDTO.LastName,
                        DateOfBirth = studentDTO.DateOfBirth,
                        Comment = studentDTO.Comment,
                        NationalityId = studentDTO.NationalityId,
                        FacultyId = studentDTO.FacultyId,
                    };
                    unitOfWork.StudentRepository.Update(student);
                    unitOfWork.Save();
                }

                return true;
            }
            catch
            {
                return false;
            }
        }

        public bool Save(StudentDTO studentDTO)
        {
            Student student = new Student
            {
                StudentId = studentDTO.Id,
                FirstName = studentDTO.FirstName,
                LastName = studentDTO.LastName,
                Comment= studentDTO.Comment,
                DateOfBirth = studentDTO.DateOfBirth,
                FacultyId = studentDTO.FacultyId,
                NationalityId = studentDTO.NationalityId
            };

            try
            {
                using (UnitOfWork unitOfWork = new UnitOfWork())
                {
                    if (studentDTO.Id == 0)
                    unitOfWork.StudentRepository.Insert(student);

                    else
                        unitOfWork.StudentRepository.Update(student);
                    unitOfWork.Save();
                }

                return true;
            }
            catch
            {
                return false;
            }
        }

        public bool Delete(int id)
        {
            try
            {
                using (UnitOfWork unitOfWork = new UnitOfWork())
                {
                    Student student = unitOfWork.StudentRepository.GetByID(id);
                    unitOfWork.StudentRepository.Delete(student);
                    unitOfWork.Save();
                }

                return true;
            }
            catch
            {
                return false;
            }
        }
    }
}
