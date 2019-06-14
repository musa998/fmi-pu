using StudentRegister.Data.Entities;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace StudentRegisterConsumer.Web.Models
{
    public class StudentViewModel
    {
        #region Properties
        public int StudentId { get; set; }

        [Required]
        public string FirstName { get; set; }

        [Required]
        public string LastName { get; set; }

        [Display(Name = "Birth Date")]
        public DateTime? DateOfBirth { get; set; }

        public string Comment { get; set; }

        [Display(Name = "Faculty")]
        public int FacultyId { get; set; }
        public FacultyViewModel FacultyVM { get; set; }
        
        public int NationalityId { get; set; }
        public virtual NationalityViewModel NationalityVM { get; set; }
        #endregion

        #region Contructors
        public StudentViewModel() { }

        public StudentViewModel(StudentViewModel studentDto)
        {
            StudentId = studentDto.StudentId;
            FirstName = studentDto.FirstName;
            LastName = studentDto.LastName;
            Comment = studentDto.Comment;

            FacultyVM = new FacultyViewModel
            {
                Id = studentDto.FacultyVM.Id,
                Name = studentDto.FacultyVM.Name,
                City = studentDto.FacultyVM.City
            };
            NationalityVM = new NationalityViewModel
            {
                Name = studentDto.NationalityVM.Name
            };
        }
        #endregion



    }
}