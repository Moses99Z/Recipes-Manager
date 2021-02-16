package com.example.RecipeManager.data;

import android.content.Context;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.RecipeManager.BuildConfig;
import com.example.RecipeManager.R;

import java.io.File;

@Database(entities = {Data.class}, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {


    private static RoomDB database;

    private static final String DATABASE_NAME = "database";

    public synchronized static RoomDB getInstance(Context context) {

        final File dbFile = context.getDatabasePath(DATABASE_NAME);


        if (database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(),
                    RoomDB.class,DATABASE_NAME).
                    allowMainThreadQueries().
                    fallbackToDestructiveMigration().
                    addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);

                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    // Data 1
                                    Uri imageURI = Uri.parse("android.resource://" + BuildConfig.APPLICATION_ID + "/" + R.drawable._382_grilled_veal_ribs);
                                    Data data1 = new Data("Grilled Veal Ribs", "Lunch", 5, "Medium", "5-6 slabs of baby back veal ribs\n" +
                                            "3 spring onions, whites and greens, chopped\n" +
                                            "8-10 garlic cloves, chopped\n" +
                                            "1 inch ginger piece, chopped\n" +
                                            "1/2 cup sake\n" +
                                            "1/4 cup rice vinegar\n" +
                                            "3/4 cup tamari soy sauce\n" +
                                            "1/4 cup fish sauce\n" +
                                            "1/4 cup honey\n" +
                                            "2 tbsp peanut oil\n" +
                                            "1 tbsp sesame oil","Mix all ingredients together and pour over the ribs.  Marinate over night.  Barbecue the ribs off flame, top down at between 300-325 F for about 3 hours, turning and basting occasionally.",
                                            imageURI.toString());
                                    // Data 2
                                    Uri imageURI2 = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.drawable._534_crockpot_beef_and_broccoli_1443306801);
                                    Data data2 = new Data("Stir-Fried Squid with Black Bean Sauce", "Lunch", 4, "Hard", "1 pound fresh cleaned squid\n" +
                                            "2 tablespoons chicken broth\n" +
                                            "2 teaspoons oyster sauce\n" +
                                            "2 teaspoons soy sauce\n" +
                                            "1 teaspoon dark soy sauce\n" +
                                            "1 teaspoon sesame oil\n" +
                                            "1/2 teaspoon cornstarch\n" +
                                            "2 tablespoons peanut or vegetable oil\n" +
                                            "2 tablespoons fermented black beans, rinsed and mashed\n" +
                                            "1 tablespoon chopped scallion, white part only\n" +
                                            "1 tablespoon thinly sliced garlic\n" +
                                            "3/4 cup thinly sliced onions\n" +
                                            "2 teaspoons finely shredded ginger\n" +
                                            "1/2 cup julienned red bell peppers\n" +
                                            "1/4 teaspoon salt\n" +
                                            "1/8 teaspoon freshly ground pepper\n" +
                                            "1 tablespoon Shao Hsing rice wine or dry sherry\n" +
                                            "12 snow peas, strings removed", "Cut each squid body in half lengthwise. Using a very sharp knife, lightly score the inside of the bodies in a crisscross pattern. Cut the squid into 1-1/2-inch squares and the tentacles into 2-inch pieces.\n" +
                                            " \n" +
                                            "In a 2-quart saucepan bring 1 quart water to a boil covered over high heat. Add the squid and blanch 10 seconds or until the squid turns opaque and curl. Drain well in a colander, shaking out all the excess water. Set the squid on paper towels and blot dry to remove excess moisture. In a small bowl combine 1 tablespoon of the broth, oyster sauce, soy sauce, and dark soy sauce. In another small bowl combine the sesame oil, cornstarch, and the remaining 1 tablespoon broth.\n" +
                                            " \n" +
                                            "Heat a 14-inch flat-bottomed wok or 12-inch skillet over high heat until a bead of water vaporizes within 1 to 2 seconds of contact. Swirl in the peanut oil, add the fermented black beans, scallion, and garlic and stir-fry 10 seconds or until the aromatics are fragrant. Add the onions and ginger and stir-fry 1 minute or until the onions just wilt. Add the bell peppers, sprinkle on the salt and pepper, and stir-fry 30 seconds or until the bell pepper begins to soften. Add the rice wine and stir-fry 20 seconds or until just combined. Add the squid and snow peas to the wok, swirl in the soy sauce mixture, and stir-fry 1 minute or until the snow peas are bright green. Restir the cornstarch mixture, swirl it into the wok, and stir-fry 30 seconds or until the squid is just cooked.",
                                            imageURI2.toString());
                                    // Data 3
                                    Uri imageURI3 = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.drawable.eggs);
                                    Data data3 = new Data("Fried Eggs with Sauteed Ramps and Duck Bacon", "Breakfast", 1, "Medium", "4 slices duck bacon, cut into 1/4-inch wide batons/lardons (you can substitute pork bacon)\n" +
                                            "1 1/2 tbsp butter\n" +
                                            "16 ramps, well-washed (like leeks there is a lot of grit in between the leaves) and ends trimmed\n" +
                                            "s&p\n" +
                                            "4 large eggs\n" +
                                            "crushed red pepper flakes", "Cook bacon in a large cast-iron skillet (or other heavy-bottomed pan) until well-rendered and crisp, about 4-5 minutes. Transfer bacon to a paper towel-lined plate, but leave rendered fat in skillet\n" +
                                            " \n" +
                                            "Add butter to bacon fat and heat over moderately-high heat until butter begins to brown. \n" +
                                            "\n" +
                                            "Add ramps and cook, stirring occasionally, until softened, wilted and beginning to brown in plates, about 1-2 minutes (if your ramps are really thin or thick it will take a little shorter or a little longer - play it by ear). Season lightly with s&p. Discard paper towel under the bacon and transfer ramps to plate with bacon.\n" +
                                            "\n" +
                                            "Crack eggs directly into skillet and fry over moderatly-high heat until whites are set on top and brown and crisp on the bottom, and yolk is still runny, about 2 minutes. Depending on the size of your pan you might have to do this in two batches. Transfer eggs to a plate, pour any remaining bacon fat and butter from the skillet over them (if any), season to taste with s&p, chili flakes. \n" +
                                            "\n" +
                                            "Serve with bacon and ramps.", imageURI3.toString());
                                    // Data 4
                                    Uri imageURI4 = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.drawable.cupcakes);
                                    Data data4 = new Data("Cherry Chip Cupcakes with Cherry Vanilla Buttercream", "Collation", 8, "Easy", "2 cups + 2 tablespoons all-purpose flour, divided\n" +
                                            "1 tablespoon baking powder\n" +
                                            "1/4 teaspoon salt\n" +
                                            "1/4 cup whole milk\n" +
                                            "1/2 cup maraschino cherry juice\n" +
                                            "2 teaspoons almond extract\n" +
                                            "1/2 cup unsalted butter\n" +
                                            "1 & 1/4 cups granulated sugar\n" +
                                            "10 ounce jar maraschino cherries, finely chopped\n" +
                                            "4 egg whites, beaten to stiff peaks\n" +
                                            "\n" +
                                            "Cherry Vanilla Buttercream\n" +
                                            "3/4 cup unsalted butter\n" +
                                            "3 & 1/2 cups powdered sugar\n" +
                                            "1/4 teaspoon salt\n" +
                                            "1 & 1/2 tablespoons whole milk\n" +
                                            "1-2 tablespoons maraschino cherry juice, to taste", "1. Preheat oven to 340°F. Line a 12-cup muffin tin with paper liners.\n" +
                                            "\n" +
                                            "2. In a medium bowl, whisk together 2 cups flour, salt, and baking powder. In a liquid measuring cup, combine the milk, cherry juice, and almond extract.\n" +
                                            "\n" +
                                            "3. In the bowl of a stand mixer, beat the butter for about one minute at medium speed. Add the sugar and mix about one minute more. Add the flour mixture and the liquid mixture alternately, beginning and ending with the flour mixture. Mix just until all ingredients are thoroughly combined, scraping the sides of the bowl as necessary.\n" +
                                            "\n" +
                                            "4. In a small bowl, sprinkle 2 tablespoons of flour over the chopped cherries. Stir until the cherries are coated and have absorbed most of the flour. Stir the cherries into the batter.\n" +
                                            "\n" +
                                            "5. Fold the beaten egg whites into the batter. Divide the batter evenly between the muffin cups; each cup should be about 2/3 full. Bake for 20-25 minutes, or until a toothpick inserted in the center cupcake comes out clean and the tops spring back when pressed gently. Cool completely before frosting.\n" +
                                            "\n" +
                                            "Cherry Vanilla Buttercream:\n" +
                                            "In the bowl of a stand mixer, beat the butter for about one minute at medium speed. Add the powdered sugar and salt, and mix at low speed until the sugar is completely incorporated. Add the milk and cherry juice. Increase the speed to medium and beat for 1-2 minutes, or until light and fluffy.",
                                            imageURI4.toString());
                                    getInstance(context).DataDao().insert(data1);
                                    getInstance(context).DataDao().insert(data2);
                                    getInstance(context).DataDao().insert(data3);
                                    getInstance(context).DataDao().insert(data4);
                                }
                            }).start();
                        }
                    }).
                    build();



        }
        return database;
    }

    public abstract DataDao DataDao();




}
