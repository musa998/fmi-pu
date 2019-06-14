using StudentRegister.ApplicationService.DTOs;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace StudentRegisterConsumer.Web.Models
{
    public class NationalityViewModel
    {
        public int Id { get; set; }

        
        public string Name { get; set; }

        #region Constructors

        public NationalityViewModel() {}

        public NationalityViewModel(NationalityDTo nationalityDTo)
        {
            Id = nationalityDTo.Id;
            Name = nationalityDTo.Name;
        }
        #endregion
    }
}