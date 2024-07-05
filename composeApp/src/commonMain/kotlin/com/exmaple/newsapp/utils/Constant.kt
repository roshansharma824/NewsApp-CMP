package com.exmaple.newsapp.utils

import News_App.composeApp.BuildConfig
import com.exmaple.newsapp.domain.model.NewsData
import kotlinx.serialization.json.Json

object Constant {
    const val BASE_URL = "https://newsapi.org/v2"
    const val TIME_OUT = 30000L
    const val API_SECRET = BuildConfig.API_SECRET

    const val jsonString: String = "{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"totalResults\": 38,\n" +
            "  \"articles\": [\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": \"the-times-of-india\",\n" +
            "        \"name\": \"The Times of India\"\n" +
            "      },\n" +
            "      \"author\": \"TOI Lifestyle Desk\",\n" +
            "      \"title\": \"Can energy drinks be directly related to heart attack? - The Times of India\",\n" +
            "      \"description\": \"Energy drinks, popular among young adults, raise concerns about health risks, including heart attacks. Among the most alarming is the possible connect\",\n" +
            "      \"url\": \"https://timesofindia.indiatimes.com/life-style/health-fitness/health-news/can-energy-drinks-be-directly-related-to-heart-attack/articleshow/110842429.cms\",\n" +
            "      \"urlToImage\": \"https://static.toiimg.com/thumb/msid-110842769,width-1070,height-580,imgsize-60816,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg\",\n" +
            "      \"publishedAt\": \"2024-06-15T10:30:00Z\",\n" +
            "      \"content\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": null,\n" +
            "        \"name\": \"Hindustan Times\"\n" +
            "      },\n" +
            "      \"author\": \"HT News Desk\",\n" +
            "      \"title\": \"Kate attends Trooping the Colour, pictured in carriage with her children: LIVE - Hindustan Times\",\n" +
            "      \"description\": \"Kate Middleton will be attending King’s Birthday Parade at Trooping the Colour ceremony today.\",\n" +
            "      \"url\": \"https://www.hindustantimes.com/world-news/kate-middletons-first-public-appearance-post-cancer-diagnosis-at-kings-birthday-parade-live-updates-101718429809909.html\",\n" +
            "      \"urlToImage\": \"https://www.hindustantimes.com/ht-img/img/2024/06/15/550x309/BRITAIN-ROYALS-KING-BIRTHDAY-20_1718446180900_1718446193555.JPG\",\n" +
            "      \"publishedAt\": \"2024-06-15T10:14:26Z\",\n" +
            "      \"content\": \"I have been blown away by all the kind messages of support and encouragement over the last couple of months. It really has made the world of difference to William and me and has helped us both throug… [+1060 chars]\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": \"the-times-of-india\",\n" +
            "        \"name\": \"The Times of India\"\n" +
            "      },\n" +
            "      \"author\": \"TIMESOFINDIA.COM\",\n" +
            "      \"title\": \"'Three legs of a rickshaw': Uddhav Thackeray targets NDA govt with Devendra Fadnavis's old remark for MVA - The Times of India\",\n" +
            "      \"description\": \"India News:  Thackeray said people of the state showed how hollow the myth of Bharatiya Janata Party's invincibility is. \\\"Lok Sabha poll victory for Maha Vikas Ag\",\n" +
            "      \"url\": \"https://timesofindia.indiatimes.com/india/lok-sabha-poll-victory-is-the-beginning-shiv-sena-ubt-chief-uddhav-thackeray-hails-mvas-election-win/articleshow/111018803.cms\",\n" +
            "      \"urlToImage\": \"https://static.toiimg.com/thumb/msid-111018849,width-1070,height-580,imgsize-1339020,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg\",\n" +
            "      \"publishedAt\": \"2024-06-15T09:49:00Z\",\n" +
            "      \"content\": \"10 animals with unique parenting behaviours\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": \"al-jazeera-english\",\n" +
            "        \"name\": \"Al Jazeera English\"\n" +
            "      },\n" +
            "      \"author\": \"Virginia Pietromarchi\",\n" +
            "      \"title\": \"G7 leaders put on good show of unity, but look fragile at home - Al Jazeera English\",\n" +
            "      \"description\": \"Group took strong lines on confronting Russia and China, but is its relevance in today’s world on the wane?\",\n" +
            "      \"url\": \"https://www.aljazeera.com/news/2024/6/15/g7-leaders-put-on-good-show-of-unity-but-look-fragile-at-home\",\n" +
            "      \"urlToImage\": \"https://www.aljazeera.com/wp-content/uploads/2024/06/GettyImages-2156915104-1718441665.jpg?resize=1920%2C1440\",\n" +
            "      \"publishedAt\": \"2024-06-15T09:30:32Z\",\n" +
            "      \"content\": \"Fasano, Italy This years G7 summit bore the hallmarks of a fragile club, yet one that still manages to put up a good fight when it comes to shielding Western interests.\\r\\nOn Saturday, the leaders of w… [+7654 chars]\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": null,\n" +
            "        \"name\": \"NDTV News\"\n" +
            "      },\n" +
            "      \"author\": null,\n" +
            "      \"title\": \"10 Dead As Tempo Traveller With 23 People Falls Into Gorge In Uttarakhand - NDTV\",\n" +
            "      \"description\": \"At least eight people were killed after a tempo traveller carrying as many as 23 people fell in a gorge in Uttarakhand on Saturday.\",\n" +
            "      \"url\": \"https://www.ndtv.com/india-news/raitoli-accident-8-dead-as-tempo-traveller-carrying-23-people-falls-in-gorge-in-uttarakhand-on-rishikesh-badrinath-highway-5895689\",\n" +
            "      \"urlToImage\": \"https://c.ndtvimg.com/2024-06/5bt16dlo_uttarakhand-tempo-accident-1200-_625x300_15_June_24.jpg?im=FaceCrop,algorithm=dnn,width=1200,height=738?ver-20240615.100\",\n" +
            "      \"publishedAt\": \"2024-06-15T09:06:57Z\",\n" +
            "      \"content\": \"The vehicle fell into the Alaknanda River\\r\\nNew Delhi: At least 10 people were killed after a tempo traveller carrying 23 passengers fell into a gorge in Uttarakhand on Saturday, officials said.\\r\\nThe … [+912 chars]\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": null,\n" +
            "        \"name\": \"The Indian Express\"\n" +
            "      },\n" +
            "      \"author\": \"The Indian Express\",\n" +
            "      \"title\": \"Voyager 1 is back! 46-year-old NASA spacecraft sends signal after going dark for months - The Indian Express\",\n" +
            "      \"description\": null,\n" +
            "      \"url\": \"https://indianexpress.com/article/technology/science/voyager-1-is-back-46-year-old-nasa-spacecraft-sends-signal-after-going-dark-for-months-9394333/\",\n" +
            "      \"urlToImage\": \"https://images.indianexpress.com/2024/06/Nasa.jpg\",\n" +
            "      \"publishedAt\": \"2024-06-15T09:01:35Z\",\n" +
            "      \"content\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": \"the-times-of-india\",\n" +
            "        \"name\": \"The Times of India\"\n" +
            "      },\n" +
            "      \"author\": \"TOI Sports Desk\",\n" +
            "      \"title\": \"'Three groups in the team; Afridi unhappy, Rizwan unhappy, Babar unable to unite players': Pakistan's rec - The Times of India\",\n" +
            "      \"description\": \"Cricket News: Pakistan's early exit from the 2024 ICC T20 World Cup was due to internal divisions and underperformance of senior players, potentially causing signif\",\n" +
            "      \"url\": \"https://timesofindia.indiatimes.com/sports/cricket/icc-mens-t20-world-cup/three-groups-in-team-afridi-unhappy-rizwan-unhappy-babar-unable-to-unite-players-reasons-for-pakistans-shock-exit-from-t20-world-cup/articleshow/111017228.cms\",\n" +
            "      \"urlToImage\": \"https://static.toiimg.com/thumb/msid-111017509,width-1070,height-580,imgsize-76434,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg\",\n" +
            "      \"publishedAt\": \"2024-06-15T08:48:00Z\",\n" +
            "      \"content\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": null,\n" +
            "        \"name\": \"NDTV News\"\n" +
            "      },\n" +
            "      \"author\": null,\n" +
            "      \"title\": \"Watch: Musk's \\\"Billion Dollar Dance\\\" As Tesla Shareholders Restore \$56 Billion Pay Package - NDTV\",\n" +
            "      \"description\": \"NDTV.com: India, Business, Bollywood, Cricket, Video and Breaking News\",\n" +
            "      \"url\": \"https://www.ndtv.com/news\",\n" +
            "      \"urlToImage\": \"https://cdn.ndtv.com/common/images/ogndtv.png\",\n" +
            "      \"publishedAt\": \"2024-06-15T08:41:18Z\",\n" +
            "      \"content\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": \"the-times-of-india\",\n" +
            "        \"name\": \"The Times of India\"\n" +
            "      },\n" +
            "      \"author\": \"TOI News Desk\",\n" +
            "      \"title\": \"BJP forms 4-member committee to look into post-poll violence in West Bengal | India News - Times of India - The Times of India\",\n" +
            "      \"description\": \"India News: The Bharatiya Janata Party (BJP) has established a four-member committee to assess the situation of post-election violence in West Bengal. The committ\",\n" +
            "      \"url\": \"https://timesofindia.indiatimes.com/india/bjp-forms-4-member-committee-to-look-into-post-poll-violence-in-west-bengal/articleshow/111016485.cms\",\n" +
            "      \"urlToImage\": \"https://static.toiimg.com/thumb/msid-111016985,width-1070,height-580,imgsize-883366,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg\",\n" +
            "      \"publishedAt\": \"2024-06-15T08:25:00Z\",\n" +
            "      \"content\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": null,\n" +
            "        \"name\": \"NDTV News\"\n" +
            "      },\n" +
            "      \"author\": \"NDTV Sports Desk\",\n" +
            "      \"title\": \"Wasim Akram Brutally Trolls Pakistan After T20 World Cup Disaster, Says, \\\"Beaten ...\\\" - NDTV Sports\",\n" +
            "      \"description\": \"Wasim Akram also said that USA deserve to be in the next round, especially after beating Pakistan.\",\n" +
            "      \"url\": \"https://sports.ndtv.com/t20-world-cup-2024/wasim-akram-brutally-trolls-pakistan-after-t20-world-cup-disaster-says-beaten-5895044\",\n" +
            "      \"urlToImage\": \"https://c.ndtvimg.com/2024-06/9ean8o3g_wasim-akram_625x300_15_June_24.jpg?im=FaceCrop,algorithm=dnn,width=1200,height=675\",\n" +
            "      \"publishedAt\": \"2024-06-15T08:13:40Z\",\n" +
            "      \"content\": \"Former Pakistan captain Wasim Akram was all praise for the United States of America (USA) after the T20 World Cup debutants qualified for the Super 8 stage of the tournament. After their rain-hit sta… [+1575 chars]\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": null,\n" +
            "        \"name\": \"CNBCTV18\"\n" +
            "      },\n" +
            "      \"author\": \"Anshul\",\n" +
            "      \"title\": \"WhatsApp's video calls get three new features: Know how they'll change your conversations - CNBCTV18\",\n" +
            "      \"description\": \"WhatsApp will introduce screen sharing during video calls, a feature recently discovered in its beta version.\",\n" +
            "      \"url\": \"https://www.cnbctv18.com/technology/whatsapp-video-calls-three-new-features-how-change-conversations-screen-sharing-limit-19428930.htm\",\n" +
            "      \"urlToImage\": \"https://images.cnbctv18.com/uploads/2024/05/whatsapp-2024-05-35c4c26f5ba8df6326b72214c23fad72.jpeg?im=FitAndFill,width=500,height=300\",\n" +
            "      \"publishedAt\": \"2024-06-15T07:45:41Z\",\n" +
            "      \"content\": \"WhatsApp is gearing up to enhance its video calling capabilities with the introduction of three new features this week. These updates aim to compete with platforms like Zoom and Google Meet.Firstly, … [+1394 chars]\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": null,\n" +
            "        \"name\": \"Crictracker.com\"\n" +
            "      },\n" +
            "      \"author\": \"Koustav Sengupta\",\n" +
            "      \"title\": \"T20 World Cup 2024: Match 33, IND vs CAN Match Prediction – Who will win today’s T20 World Cup match between IND vs CAN? - CricTracker\",\n" +
            "      \"description\": \"With three wins to their name, India (IND) are on top of the Group A points table. Up next, the Rohit Sharma-led side will face Canada (CAN) on June 15 at Central Broward Regional Park Stadium Turf Gr\",\n" +
            "      \"url\": \"https://www.crictracker.com/cricket-match-predictions/t20-world-cup-2024-match-33-ind-vs-can-match-prediction-who-will-win-todays-t20-world-cup-match-between-ind-vs-can-1728/\",\n" +
            "      \"urlToImage\": \"https://media.crictracker.com/media/attachments/1718278459668_Team-India.jpeg\",\n" +
            "      \"publishedAt\": \"2024-06-15T07:00:00Z\",\n" +
            "      \"content\": \"With three wins to their name, India (IND) are on top of the Group A points table. Up next, the Rohit Sharma-led side will face Canada (CAN) on June 15 at Central Broward Regional Park Stadium Turf G… [+3479 chars]\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": \"the-hindu\",\n" +
            "        \"name\": \"The Hindu\"\n" +
            "      },\n" +
            "      \"author\": \"The Hindu\",\n" +
            "      \"title\": \"8 Naxalites, one security officer killed in encounter in Chhattisgarh - The Hindu\",\n" +
            "      \"description\": null,\n" +
            "      \"url\": \"https://www.thehindu.com/news/national/encounter-breaks-out-between-security-personnel-and-naxalites-in-chhattisgarh/article68292553.ece\",\n" +
            "      \"urlToImage\": \"https://th-i.thgim.com/public/incoming/vyp4rq/article68294624.ece/alternates/FREE_1200/PTI06_15_2024_000308B.jpg\",\n" +
            "      \"publishedAt\": \"2024-06-15T06:52:00Z\",\n" +
            "      \"content\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": \"the-times-of-india\",\n" +
            "        \"name\": \"The Times of India\"\n" +
            "      },\n" +
            "      \"author\": \"Ramita Rajaa, ET BrandEquity\",\n" +
            "      \"title\": \"From AI to privacy: Adapting to the marketing metamorphosis from Apple WWDC 2024 - ETBrandEquity\",\n" +
            "      \"description\": \"Siri is now equipped with powerful AI-driven capabilities that enable the assistant to take actions within multiple apps simultaneously and surface search results without ever opening any app. App marketers need to arm Siri with the right app navigation infor…\",\n" +
            "      \"url\": \"https://brandequity.economictimes.indiatimes.com/news/digital/from-ai-to-privacy-adapting-to-the-marketing-metamorphosis-from-apple-wwdc-2024/111014667\",\n" +
            "      \"urlToImage\": \"https://etimg.etb2bimg.com/thumb/msid-111014667,imgsize-16330,width-1200,height=765,overlay-etbrandequity/digital/from-ai-to-privacy-adapting-to-the-marketing-metamorphosis-from-apple-wwdc-2024.jpg\",\n" +
            "      \"publishedAt\": \"2024-06-15T06:30:08Z\",\n" +
            "      \"content\": \"Apple WWDC 2024\\r\\nApple WWDC 2024 created a stir in the tech world. The tech giant unveiled Apple Intelligence and a native ChatGPT integration to weave AI into every aspect of the Apple ecosystem. Ne… [+4563 chars]\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": null,\n" +
            "        \"name\": \"Onmanorama.com\"\n" +
            "      },\n" +
            "      \"author\": \"Onmanorama Staff\",\n" +
            "      \"title\": \"After crown, Suresh Gopi offers golden rosary to Thrissur's Lourdes Church | Thrissur News - Onmanorama\",\n" +
            "      \"description\": \"During his election campaign, a controversy arose regarding the actor-turned-politician offering a golden crown to Our Lady of Lourdes.\",\n" +
            "      \"url\": \"https://www.onmanorama.com/news/kerala/2024/06/15/suresh-gopi-golden-rosary-thrissur-lourdes-church.html\",\n" +
            "      \"urlToImage\": \"https://img.onmanorama.com/content/dam/mm/en/kerala/top-news/images/2024/6/15/suresh-gopi-lourdes-rosary.jpg\",\n" +
            "      \"publishedAt\": \"2024-06-15T05:46:25Z\",\n" +
            "      \"content\": \"Thrissur: Union Minister of State for Petroleum and Natural Gas and the Ministry of Tourism, Suresh Gopi, presented a golden rosary to the Lourdes Metropolitan Cathedral here on Saturday. The ministe… [+1983 chars]\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": \"the-times-of-india\",\n" +
            "        \"name\": \"The Times of India\"\n" +
            "      },\n" +
            "      \"author\": \"TOI News Desk\",\n" +
            "      \"title\": \"High court directs Delhi CM's wife Sunita Kejriwal, others to take down video of court proceedings - The Times of India\",\n" +
            "      \"description\": \"India News: The Delhi high court on Saturday instructed Delhi CM Arvind Kejriwal's wife and five other individual respondents to remove video recordings of a cour\",\n" +
            "      \"url\": \"https://timesofindia.indiatimes.com/india/high-court-directs-delhi-cms-wife-sunita-kejriwal-others-to-take-down-video-of-court-proceedings/articleshow/111013464.cms\",\n" +
            "      \"urlToImage\": \"https://static.toiimg.com/thumb/msid-111014487,width-1070,height-580,imgsize-1312410,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg\",\n" +
            "      \"publishedAt\": \"2024-06-15T05:31:00Z\",\n" +
            "      \"content\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": \"the-hindu\",\n" +
            "        \"name\": \"The Hindu\"\n" +
            "      },\n" +
            "      \"author\": \"The Hindu\",\n" +
            "      \"title\": \"G7 Summit commits to promoting India-Middle East-Europe Economic Corridor - The Hindu\",\n" +
            "      \"description\": null,\n" +
            "      \"url\": \"https://www.thehindu.com/news/international/g7-summit-commits-to-promoting-india-middle-east-europe-economic-corridor/article68292418.ece\",\n" +
            "      \"urlToImage\": \"https://th-i.thgim.com/public/incoming/eh4efa/article68292433.ece/alternates/LANDSCAPE_1200/AFP_34WR23X.jpg\",\n" +
            "      \"publishedAt\": \"2024-06-15T05:06:06Z\",\n" +
            "      \"content\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": \"the-times-of-india\",\n" +
            "        \"name\": \"The Times of India\"\n" +
            "      },\n" +
            "      \"author\": \"TOI World Desk\",\n" +
            "      \"title\": \"On 78th birthday, Donald Trump mocks rival Joe Biden over his age - Times of India - The Times of India\",\n" +
            "      \"description\": \"US News: NEW DELHI: Former US president and republican candidate Donald Trump celebrated his 78th birthday on Friday night with a multi-tiered cake featuring v.\",\n" +
            "      \"url\": \"https://timesofindia.indiatimes.com/world/us/on-78th-birthday-donald-trump-mocks-rival-joe-biden-over-his-age/articleshow/111013166.cms\",\n" +
            "      \"urlToImage\": \"https://static.toiimg.com/thumb/msid-111013251,width-1070,height-580,imgsize-449498,resizemode-75,overlay-toi_sw,pt-32,y_pad-40/photo.jpg\",\n" +
            "      \"publishedAt\": \"2024-06-15T05:04:00Z\",\n" +
            "      \"content\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"source\": {\n" +
            "        \"id\": null,\n" +
            "        \"name\": \"Moneycontrol\"\n" +
            "      },\n" +
            "      \"author\": \"PTI\",\n" +
            "      \"title\": \"PM Modi, Japanese PM Kishida agree to advance infrastructure, cultural ties - Moneycontrol\",\n" +
            "      \"description\": \"The discussions concluded with a commitment to further deepen bilateral cooperation across new and emerging sectors, enhance business-to-business and people-to-people ties, and strengthen infrastructure and cultural linkages. The leaders agreed to continue th…\",\n" +
            "      \"url\": \"https://www.moneycontrol.com/news/world/pm-modi-japanese-pm-kishida-agree-to-advance-infrastructure-cultural-ties-12749327.html\",\n" +
            "      \"urlToImage\": \"https://images.moneycontrol.com/static-mcnews/2022/05/pjimage-55.jpg\",\n" +
            "      \"publishedAt\": \"2024-06-15T04:59:54Z\",\n" +
            "      \"content\": \"During the sidelines of the G-7 Summit 2024 held in Italys Apulia, Prime Minister Narendra Modi engaged in a bilateral meeting with Japanese Prime Minister Fumio Kishida. The discussions primarily fo… [+1790 chars]\"\n" +
            "    }\n" +
            "  ]\n" +
            "}"

    val newsData = Json.decodeFromString<NewsData>(jsonString)
}