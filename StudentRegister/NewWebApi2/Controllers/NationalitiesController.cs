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
    public class NationalitiesController : ApiController
    {
        private StudentRegisterDBContext db = new StudentRegisterDBContext();

        #region Properties
        private readonly NationalityManagmentService _service = null;
        #endregion

        #region Constructors
        public NationalitiesController()
        {
            _service = new NationalityManagmentService();
        }
        #endregion

        // GET: api/Nationalities
        public IHttpActionResult GetNationalities()
        {
            return Json(_service.Get());
        }

        // GET: api/Nationalities/5
        [ResponseType(typeof(Nationality))]
        public IHttpActionResult GetNationality(int id)
        {

            Nationality nationality = db.Nationalities.Find(id);
            if (nationality == null)
            {
                return NotFound();
            }

            return Json(_service.GetById(id));
        }

        // PUT: api/Nationalities/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutNationality(int id, NationalityDTo nationality)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != nationality.Id)
            {
                return BadRequest();
            }

            _service.Update(nationality);


            return StatusCode(HttpStatusCode.OK);
        }

        // POST: api/Nationalities
        [HttpPost]
        public IHttpActionResult PostNationality(NationalityDTo nationality)
        {
            if (!ModelState.IsValid)
            {
                return Json(new ResponseMessage { Code = 500, Error = "Data is not valid!" });
            }
            ResponseMessage response = new ResponseMessage();
            NationalityDTo nationalityDTO = new NationalityDTo
            {
                Id = nationality.Id,
                Name = nationality.Name
            };

            _service.Save(nationalityDTO);

            response.Code = 200;
            response.Body = "Student added";

            return Json(response);
        }

        // DELETE: api/Nationalities/5
        [ResponseType(typeof(NationalityDTo))]
        public IHttpActionResult DeleteNationality(int id)
        {
            NationalityDTo nationality = _service.GetById(id);
            if (nationality == null)
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

        private bool NationalityExists(int id)
        {
            return db.Nationalities.Count(e => e.NationalityId == id) > 0;
        }
    }
}