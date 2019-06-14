using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using StudentRegister.Data.Context;
using StudentRegister.Data.Entities;
using StudentRegister.ApplicationService.Implementations;
using StudentRegister.ApplicationService.DTOs;
using NewWebApi2.Messages;

namespace NewWebApi2.Controllers
{
    public class FacultiesController : ApiController
    {
        private StudentRegisterDBContext db = new StudentRegisterDBContext();
        #region Properties
        private readonly FacultyManagmentService _service = null;
        #endregion

        #region Constructors
        public FacultiesController()
        {
            _service = new FacultyManagmentService();
        }
        #endregion


        // GET: api/Faculties
        [HttpGet]
        public IHttpActionResult GetFaculties()
        {
            return Json(_service.Get());
        }

        // GET: api/Faculties/5
        [ResponseType(typeof(Faculty))]
        public IHttpActionResult GetFaculty(int id)
        {

            Faculty faculty = db.Faculties.Find(id);
            if (faculty == null)
            {
                return NotFound();
            }

            return Json(_service.GetById(id));
        }

        // PUT: api/Faculties/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutFaculty(int id, FacultyDTO faculty)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != faculty.Id)
            {
                return BadRequest();
            }

            _service.Update(faculty);


            return StatusCode(HttpStatusCode.OK);
        }

        // POST: api/Faculties
        [HttpPost]
        public IHttpActionResult PostFacultyt(FacultyDTO faculty)
        {
            if (!ModelState.IsValid)
            {
                return Json(new ResponseMessage { Code = 500, Error = "Data is not valid!" });
            }
            ResponseMessage response = new ResponseMessage();

            //FacultyDTO facultyDto = new FacultyDTO
            //{
            //     Id = faculty.Id,
            //    Name = faculty.Name,
            //    City = faculty.City,
            //    Address = faculty.Address
            //};

            _service.Save(faculty);
            response.Code = 200;
            response.Body = "Student added";

            return Json(response);
        }

        // DELETE: api/Faculties/5
        [ResponseType(typeof(FacultyDTO))]
        public IHttpActionResult DeleteFaculty(int id)
        {
            FacultyDTO faculty = _service.GetById(id);  
            if (faculty == null)
            {
                return NotFound();
            }
            _service.Delete(id);
            ResponseMessage response = new ResponseMessage();

            response.Code = 200;
            response.Body = "Faculty deleted";
            return Json(response);

        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool FacultyExists(int id)
        {
            return db.Faculties.Count(e => e.FacultyId == id) > 0;
        }
    }
}