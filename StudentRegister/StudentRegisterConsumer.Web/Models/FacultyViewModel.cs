using StudentRegister.ApplicationService.DTOs;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace StudentRegisterConsumer.Web.Models
{
    public class FacultyViewModel
    {
        public int Id { get; set; }

       
        public string Name { get; set; }

        
        public string City { get; set; }

        public string Address { get; set; }

        #region Contructors
        public FacultyViewModel() { }

        public FacultyViewModel(FacultyDTO facultyDto)
        {
            Id = facultyDto.Id;
            Name = facultyDto.Name;
            City = facultyDto.City;
            Address = facultyDto.Address;
        }
        #endregion
    }
}