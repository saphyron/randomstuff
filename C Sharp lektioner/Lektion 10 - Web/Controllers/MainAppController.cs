using Lektion_10___Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Lektion_10___Web.Controllers
{
    public class MainAppController : Controller
    {
        Person p1 = new Person("John", "Resedavej 49", 30, "Test");
        // GET: MainApp
        public ActionResult Index()
        {
            return View();
        }
        public string DemoAction()
        {
            return "Hello from DemoAction";
        }
        public ActionResult DemoActionTool()
        {
            return View();
        }
        public ActionResult AboutMe()
        {
            return View();
        }
        public ActionResult Download()
        {
            return View();
        }
        public ActionResult PersonPage(string option)
        {
            return View(option);
        }

    }
}