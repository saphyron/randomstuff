//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace EksamensOpgave_Web.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class bydning
    {
        public int bydningsNr { get; set; }
        public Nullable<int> KundeNr { get; set; }
        public Nullable<int> PiID { get; set; }
        public Nullable<bool> budt { get; set; }
    
        public virtual kunde kunde { get; set; }
        public virtual produkter produkter { get; set; }
    }
}
