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
  public  class FacultyManagmentService
    {
        public List<FacultyDTO> Get()
        {
            List<FacultyDTO> facultyDto = new List<FacultyDTO>();

            using (UnitOfWork unitOfWork = new UnitOfWork())
            {
                foreach (var item in unitOfWork.FacultyReposiotry.Get())
                {
                    facultyDto.Add(new FacultyDTO
                    {
                        Id = item.FacultyId,
                        Name = item.Name,
                        City = item.City,
                        Address = item.Address
                    });
                }
            }

            return facultyDto;
        }
        public FacultyDTO GetById(int id)
        {
            FacultyDTO facultyDTO = new FacultyDTO();

            using (UnitOfWork unitOfWork = new UnitOfWork())
            {
                Faculty faculty = unitOfWork.FacultyReposiotry.GetByID(id);
                facultyDTO = new FacultyDTO
                {
                    Id = id,
                    Name = faculty.Name,
                    City = faculty.City,
                    Address = faculty.Address,
                };
            }

            return facultyDTO;
        }

        public bool Update(FacultyDTO faculty)
        {
            if (faculty.Id == 0) return false;

            try
            {
                using (UnitOfWork unitOfWork = new UnitOfWork())
                {
                    //Nationality nationality = unitOfWork.NationalityRepository.GetByID(id);
                    Faculty faculty2 = new Faculty
                    {
                        FacultyId = faculty.Id,
                        Name = faculty.Name,
                        City = faculty.City,
                        Address = faculty.Address
                    };
                    unitOfWork.FacultyReposiotry.Update(faculty2);
                    unitOfWork.Save();
                }

                return true;
            }
            catch
            {
                return false;
            }
        }

        public bool Save(FacultyDTO facultyDTO)
        {
            Faculty faculty = new Faculty
            {
                FacultyId = facultyDTO.Id,
                Name = facultyDTO.Name,
                City = facultyDTO.City,
                Address = facultyDTO.Address
            };

            try
            {
                using (UnitOfWork unitOfWork = new UnitOfWork())
                {
                    if (facultyDTO.Id == 0)
                        unitOfWork.FacultyReposiotry.Insert(faculty);
                    else
                        unitOfWork.FacultyReposiotry.Update(faculty);
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
            if (id == 0) return false;

            try
            {
                using (UnitOfWork unitOfWork = new UnitOfWork())
                {
                    Faculty faculty = unitOfWork.FacultyReposiotry.GetByID(id);
                    unitOfWork.FacultyReposiotry.Delete(faculty);
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
