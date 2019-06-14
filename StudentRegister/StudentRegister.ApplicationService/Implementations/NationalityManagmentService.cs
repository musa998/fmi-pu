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
    public class NationalityManagmentService
    {
        public List<NationalityDTo> Get()
        {
            List<NationalityDTo> nationalityDto = new List<NationalityDTo>();

            using (UnitOfWork unitOfWork = new UnitOfWork())
            {
                foreach (var item in unitOfWork.NationalityRepository.Get())
                {
                    nationalityDto.Add(new NationalityDTo
                    {
                        Id = item.NationalityId,
                        Name = item.Name
                    });
                }
            }

            return nationalityDto;
        }
        public NationalityDTo GetById(int id)
        {
            NationalityDTo nationalityDTO = new NationalityDTo();

            using (UnitOfWork unitOfWork = new UnitOfWork())
            {
                Nationality nationality = unitOfWork.NationalityRepository.GetByID(id);
                nationalityDTO = new NationalityDTo
                {
                    Id = id,
                    Name = nationality.Name,
                };
            }

            return nationalityDTO;
        }

        public bool Save(NationalityDTo nationalityDto)
        {
            Nationality nationality = new Nationality
            {
                NationalityId = nationalityDto.Id,
                Name = nationalityDto.Name
            };

            try
            {
                using (UnitOfWork unitOfWork = new UnitOfWork())
                {
                    if (nationalityDto.Id == 0)
                        unitOfWork.NationalityRepository.Insert(nationality);
                    else
                        unitOfWork.NationalityRepository.Update(nationality);
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
                    Nationality nationality = unitOfWork.NationalityRepository.GetByID(id);
                    unitOfWork.NationalityRepository.Delete(nationality);
                    unitOfWork.Save();
                }

                return true;
            }
            catch
            {
                return false;
            }
        }
        public bool Update(NationalityDTo nationality)
        {
            if (nationality.Id == 0) return false;

            try
            {
                using (UnitOfWork unitOfWork = new UnitOfWork())
                {
                    //Nationality nationality = unitOfWork.NationalityRepository.GetByID(id);
                    Nationality nationality2 = new Nationality
                    {
                        NationalityId = nationality.Id,
                        Name = nationality.Name
                    };
                    unitOfWork.NationalityRepository.Update(nationality2);
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

