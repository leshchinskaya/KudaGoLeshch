package com.example.mariya.kudagoleshch.view

/*
class MainActivity : AppCompatActivity(), BaseInterface.View {

    private lateinit var pref: SharedPreferences
    lateinit var nameOfCurrentCity: String
    private val REQUEST_CODE_MESSAGE = 1000
    private lateinit var mPresenter: BaseInterface.Presenter
    private lateinit var mTextView: TextView
    var events: ArrayList<Event> = ArrayList()

    /*
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        /*
        if (outState != null) {
            outState.clear()
            outState.putSerializable("nameOfCurrentCity", nameOfCurrentCity)
        }
        */
    }
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = BasePresenterClass(this)
        nameOfCurrentCity = "Москва"

        /*
        if (savedInstanceState == null || !!savedInstanceState.containsKey("nameOfCurrentCity")) {
            getSavedLastSelectedCity()
        } else {
            textCity.text = savedInstanceState.getSerializable("nameOfCurrentCity").toString()
           // nameOfCurrentCity = getIntent().getStringExtra("selectedCity");
        }
        */

        //mPresenter.addEvents(events)
        addEvents()
        eventsRecyclerView.layoutManager = LinearLayoutManager(this)
        eventsRecyclerView.adapter = EventAdapter(events)


        textCity.setOnClickListener { onClickCityButton() }
        button_choiceCity.setOnClickListener { onClickCityButton() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_MESSAGE -> {
                    if (data != null) {
                        //var cityNew = data.getParcelableExtra<City>("selectedCity")
                        nameOfCurrentCity = data.getStringExtra("selectedCity")
                        textCity.text = nameOfCurrentCity
                    }
                }
            }
        }

    }

    override fun showLastEvents(string: String) {
        mTextView.text = string
    }


    fun addEvents(){
        events.add(Event("МУЗЫКАЛЬНЫЙ ФЕСТИВАЛЬ LIVEFEST SUMMER", "Первый фестиваль LiveFest на курорте «Роза Хутор» собрал перспективные музыкальные...", "ЦПКиО им. Горького", "10-11 августа", "1200-1500 Р"))
        events.add(Event("Рестобар «Чеширский кот»", "Из центра Москвы — прямиком в Зазеркалье! В рестобаре вас встретят улыбчивый кот и д...", "ул. Кузнецкий Мост, д. 19/1", "-", "2 500 Р"))
    }

    /*
    private fun getSavedLastSelectedCity() {
        pref = getSharedPreferences("settings", Context.MODE_PRIVATE)

        if (pref.contains("nameOfCurrentCity")) {
                nameOfCurrentCity = pref.getString("nameOfCurrentCity", "Москва")
                } else {
                        nameOfCurrentCity = "Москва"
        }
        
        textCity.text = nameOfCurrentCity
    }
    */

    private fun onClickCityButton() {
        val intentSelectCity = Intent(this, CityActivity::class.java)
        intentSelectCity.putExtra("currentCity", nameOfCurrentCity)
        startActivityForResult(intentSelectCity, REQUEST_CODE_MESSAGE)
    }

    private val onClickEvent = fun(event: Event) : Unit {
        val intentSelectEvent = Intent(this, DetailingEventActivity::class.java)
        intentSelectEvent.putExtra("selectedEvent", event)
        setResult(Activity.RESULT_OK, intentSelectEvent)
        startActivity(intentSelectEvent)
    }

}
*/