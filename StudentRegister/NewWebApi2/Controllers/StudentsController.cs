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
    public class StudentsController : ApiController
    {
        private StudentRegisterDBContext db = new StudentRegisterDBContext();
        #region Properties
        private readonly StudentManagmentService _service = null;
        #endregion

        #region Constructors
        public StudentsController()
        {
            _service = new StudentManagmentService();
        }
        #endregion

        // GET: api/Students
        [HttpGet]
        public IHttpActionResult GetStudents()
        {
            return Json(_service.Get());
        }

        // GET: api/Students/5
        [HttpGet]
        public IHttpActionResult GetStudent(int id)
        {
          

            Student student = db.Students.Find(id);
            if (student == null)
            {
                return NotFound();
            }

            return Json(_service.GetById(id));
        }

        // PUT: api/Students/5
        //[ResponseType(typeof(void))]
        public IHttpActionResult PutStudent(int id, StudentDTO student)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != student.Id)
            {
                return BadRequest();
            }

            _service.Update(student);


            return StatusCode(HttpStatusCode.OK);
        }

        // POST: api/Students
        [HttpPost]
        public IHttpActionResult PostStudent(StudentDTO student)
        {
            if (!ModelState.IsValid)
            {
                return Json(new ResponseMessage { Code = 500, Error = "Data is not valid!" });
            }
            ResponseMessage response = new ResponseMessage();
            //StudentDTO studentDto = new StudentDTO
            //{
              
            //    FirstName = student.FirstName,
            //    LastName = student.LastName,
            //    Comment = student.Comment,
            //    FacultyId = student.FacultyId,
            //    NationalityId = student.NationalityId,
            //    DateOfBirth = student.DateOfBirth
            //};

            _service.Save(student);

            response.Code = 200;
            response.Body = "Student added";

             return Json(response);
        }

        // DELETE: api/Students/5
        [ResponseType(typeof(StudentDTO))]
        public IHttpActionResult DeleteStudent(int id)
        {
            StudentDTO student = _service.GetById(id);

            if (student == null)
            {
                return NotFound();
            }

            _service.Delete(id);

            return Ok(student);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool StudentExists(int id)
        {
            return db.Students.Count(e => e.StudentId == id) > 0;
        }
    }
}