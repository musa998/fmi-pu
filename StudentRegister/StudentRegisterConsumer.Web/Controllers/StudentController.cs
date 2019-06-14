using Newtonsoft.Json;
using StudentRegister.ApplicationService.DTOs;
using StudentRegisterConsumer.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;

namespace StudentRegisterConsumer.Web.Controllers
{
    public class StudentController : Controller
    {
        private readonly Uri url = new Uri("http://localhost:3793/api/Students");

        public ActionResult Index()
        {
            var students = GetStudentsFromApi();

            return View(students);
        }

        
        private List<StudentViewModel> GetStudentsFromApi()
        {
            try
            {
                var resultList = new List<StudentViewModel>();
                var client = new HttpClient();

                var getDataTask = client.GetAsync("http://localhost:3793/api/Students")
                    .ContinueWith(response =>
                    {
                        var result = response.Result;
                        if (result.StatusCode == System.Net.HttpStatusCode.OK)
                        {
                            var readResult = result.Content.ReadAsAsync<List<StudentViewModel>>();
                            readResult.Wait();

                            resultList = readResult.Result;
                        }
                    });
                getDataTask.Wait();
                return resultList;

            }
            catch (Exception)
            {

                throw;
            }
        }

        private static async Task<string> GetAccessToken()
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:3793");

                // We want the response to be JSON.
                client.DefaultRequestHeaders.Accept.Clear();
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                // Build up the data to POST.
                List<KeyValuePair<string, string>> postData = new List<KeyValuePair<string, string>>
                {
                    new KeyValuePair<string, string>("grant_type", "password"),
                    new KeyValuePair<string, string>("username", "pavel"),
                    new KeyValuePair<string, string>("password", "123123")
                };

                FormUrlEncodedContent content = new FormUrlEncodedContent(postData);

                // Post to the Server and parse the response.
                HttpResponseMessage response = await client.PostAsync("Token", content);
                string jsonString = await response.Content.ReadAsStringAsync();
                object responseData = JsonConvert.DeserializeObject(jsonString);

                // return the Access Token.
                return ((dynamic)responseData).access_token;
            }

        }
        //public async Task<ActionResult> Index()
        //{
        //    string accessToken = await GetAccessToken();

        //    using (var client = new HttpClient())
        //    {
        //        client.BaseAddress = url;
        //        client.DefaultRequestHeaders.Accept.Clear();
        //        client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

        //        // Add the Authorization header with the AccessToken.
        //        client.DefaultRequestHeaders.Add("Authorization", "Bearer " + accessToken);

        //        // make the request
        //        HttpResponseMessage response = await client.GetAsync("getall");

        //        // parse the response and return the data.
        //        string jsonString = await response.Content.ReadAsStringAsync();
        //        var responseData = JsonConvert.DeserializeObject<List<StudentViewModel>>(jsonString);
        //        return View(responseData);
        //    }
        //}
        public ActionResult GetMembers()
        {
            IEnumerable<StudentViewModel> members = null;

            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:3793/api/");

                //Called Member default GET All records  
                //GetAsync to send a GET request   
                // PutAsync to send a PUT request  
                var responseTask = client.GetAsync("member");
                responseTask.Wait();

                //To store result of web api response.   
                var result = responseTask.Result;

                //If success received   
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<IList<StudentViewModel>>();
                    readTask.Wait();

                    members = readTask.Result;
                }
                else
                {
                    //Error response received   
                    members = Enumerable.Empty<StudentViewModel>();
                    ModelState.AddModelError(string.Empty, "Server error try after some time.");
                }
            }
            return View(members);
        }

        public ActionResult Create()
        {
            return View();
        }

       


        [HttpPost]
        public ActionResult Create(StudentDTO student)
        {
            StudentDTO studentDto = null;

            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:3793/api/Students/Create");

               

                if (ModelState.IsValid)
                {
                     studentDto = new StudentDTO
                    {
                        
                        FirstName = student.FirstName,
                        DateOfBirth = student.DateOfBirth,
                        LastName = student.LastName,
                        Comment = student.Comment,
                        FacultyId = student.FacultyId,
                        NationalityId = student.NationalityId
                    };
                }

                //HTTP POST
             
                var postTask = client.PostAsJsonAsync<StudentDTO>("student", studentDto);
                postTask.Wait();

                var result = postTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    return RedirectToAction("Index");
                }
            }

            ModelState.AddModelError(string.Empty, "Server Error. Please contact administrator.");

            return View(studentDto);
        }

        public ActionResult Edit(int id)
        {
            StudentDTO student = new StudentDTO();

            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:3793/api/Students/Edit");
                //HTTP GET
                var responseTask = client.GetAsync("student?id=" + id.ToString());
                responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<StudentDTO>();
                    readTask.Wait();

                    student = readTask.Result;
                }
            }

            return View(student);
        }
        [HttpPost]
        public ActionResult Edit(StudentDTO student)
        {

            student.FacultyId = 8;
            student.NationalityId = 3;
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:3793/api/Students/"+student.Id);

                var response = client.PostAsJsonAsync("http://localhost:3793/api/Students/"+student.Id, student);
                response.Wait();
                var res = response.Result;

                //HTTP POST
                var putTask = client.PutAsJsonAsync<StudentDTO>("student", student);
                putTask.Wait();

                var result = putTask.Result;
                if (result.IsSuccessStatusCode)
                {

                    return RedirectToAction("Index");
                }
            }
            return View(student);
        }

        public ActionResult Delete(int id)
        {
            using (var client = new HttpClient())
            {
                string uri = "http://localhost:3793/api/Student/"+id;

                client.BaseAddress = new Uri(uri);

                //HTTP DELETE
                var deleteTask = client.DeleteAsync("/Delete" + id.ToString());
                deleteTask.Wait();

                var result = deleteTask.Result;
                if (result.IsSuccessStatusCode)
                {

                    return RedirectToAction("Index");
                }
            }

            return RedirectToAction("Index");
        }









    }
}